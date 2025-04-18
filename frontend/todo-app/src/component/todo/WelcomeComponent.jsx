import { useParams, Link } from "react-router-dom";
import axios from "axios";
import { useState } from "react";

export default function WelcomeComponent() {
    const { username } = useParams();

    const [message, setMessage] = useState(null);

    function callHelloWorldRestApi() {
        // axios
        //     .get("http://localhost:8080/hello-world")
        //     .then((response) => successfulResponse(response))
        //     .catch((error) => errorResponse(error))
        //     .finally(() => console.log("정리"));

        axios
            .get("http://localhost:8080/hello-world-bean")
            .then((response) => successfulResponse(response))
            .catch((error) => errorResponse(error))
            .finally(() => console.log("정리"));
    }

    function successfulResponse(response) {
        console.log(response);
        // setMessage(response.data);
        setMessage(response.data.message);
    }

    function errorResponse(error) {
        console.log(error);
    }

    return (
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>
                Todos <Link to="/todos">보러가기</Link>
            </div>
            <div>
                <button
                    className="btn btn-success m-5"
                    onClick={callHelloWorldRestApi}
                >
                    Hello World REST API 호출
                </button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    );
}
