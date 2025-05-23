import { useNavigate, useParams } from "react-router-dom";
import { useAuth } from "./security/AuthContext";
import {
    createTodoApi,
    retrieveTodoApi,
    updateTodoApi,
} from "./api/TodoApiService";
import { useEffect, useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import moment from "moment";

export default function TodoComponent() {
    const { id } = useParams();
    const authContext = useAuth();
    const navigate = useNavigate();
    const username = authContext.username;
    const [description, setDescription] = useState("");
    const [targetDate, setTargetDate] = useState("");

    useEffect(() => retrieveTodos(), [id]);

    function retrieveTodos() {
        if (id != -1) {
            retrieveTodoApi(username, id)
                .then((response) => {
                    setDescription(response.data.description);
                    setTargetDate(response.data.targetDate);
                })
                .catch((error) => console.log(error));
        }
    }

    function onSubmit(values) {
        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false,
        };
        console.log(todo);

        if (id == -1) {
            createTodoApi(username, todo)
                .then((response) => {
                    navigate("/todos");
                })
                .catch((error) => console.log(error));
        } else {
            updateTodoApi(username, id, todo)
                .then((response) => {
                    navigate("/todos");
                })
                .catch((error) => console.log(error));
        }
    }

    function validate(values) {
        let errors = {};

        if (values.description.length < 5) {
            errors.description = "최소 5자 이상 작성하세요.";
        }

        if (values.targetDate === "" || !moment(values.targetDate).isValid()) {
            errors.targetDate = "날짜를 선택하세요.";
        }

        console.log(values);
        return errors;
    }

    return (
        <div className="container">
            <h1>Todo</h1>
            <div>
                <Formik
                    initialValues={{ description, targetDate }}
                    enableReinitialize={true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                    {(props) => (
                        <Form>
                            <ErrorMessage
                                name="description"
                                component="div"
                                className="alert alert-warning"
                            />

                            <ErrorMessage
                                name="targetDate"
                                component="div"
                                className="alert alert-warning"
                            />
                            <fieldse className="form-group">
                                <label>Description</label>
                                <Field
                                    type="text"
                                    className="form-control"
                                    name="description"
                                />
                            </fieldse>
                            <fieldse className="form-group">
                                <label>Target Date</label>
                                <Field
                                    type="date"
                                    className="form-control"
                                    name="targetDate"
                                />
                            </fieldse>
                            <div>
                                <button
                                    className="btn btn-success m-5"
                                    type="submit"
                                >
                                    Save
                                </button>
                            </div>
                        </Form>
                    )}
                </Formik>
            </div>
        </div>
    );
}
