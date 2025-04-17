import { useState } from "react";
import {
    BrowserRouter,
    Routes,
    Route,
    useNavigate,
    useParams,
    Link,
} from "react-router-dom";
import "./TodoApp.css";

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <HeaderComponent />
                <Routes>
                    <Route path="/" element={<LoginComponent />} />
                    <Route path="/login" element={<LoginComponent />} />
                    <Route
                        path="/welcome/:username"
                        element={<WelcomeComponent />}
                    />
                    <Route path="/todos" element={<ListTodosComponent />} />
                    <Route path="/logout" element={<LogoutComponent />} />
                    <Route path="*" element={<ErrorComponent />} />
                </Routes>
                <FooterComponent />
            </BrowserRouter>
        </div>
    );
}

function LoginComponent() {
    const [username, setUsername] = useState("test-name");
    const [password, setPassword] = useState("");
    const [showSuccessMessage, setShowSuccessMessage] = useState(false);
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const navigate = useNavigate();

    function handleUsernameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function handleSubmit() {
        console.log(username);
        console.log(password);
        if (username === "test-name" && password === "testpw") {
            setShowSuccessMessage(true);
            setShowErrorMessage(false);
            navigate(`/welcome/${username}`);
        } else {
            setShowSuccessMessage(false);
            setShowErrorMessage(true);
        }
    }

    return (
        <div className="Login">
            <h1>Login</h1>
            {showSuccessMessage && (
                <div className="successMessage">로그인 성공</div>
            )}
            {showErrorMessage && (
                <div className="errorMessage">로그인 실패</div>
            )}

            <div className="LoginForm">
                <div>
                    <label>name: </label>
                    <input
                        type="text"
                        name="username"
                        value={username}
                        onChange={handleUsernameChange}
                    />
                </div>
                <div>
                    <label>password: </label>
                    <input
                        type="password"
                        name="password"
                        value={password}
                        onChange={handlePasswordChange}
                    />
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>
                        login
                    </button>
                </div>
            </div>
        </div>
    );
}

function WelcomeComponent() {
    const { username } = useParams();
    console.log(username);

    return (
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>
                Todos <Link to="/todos">보러가기</Link>
            </div>
        </div>
    );
}

function ErrorComponent() {
    return (
        <div className="ErrorComponent">
            <h1>Error</h1>
            <div>페이지를 찾을 수 없습니다 404</div>
        </div>
    );
}

function ListTodosComponent() {
    const today = new Date();
    const targetDate = new Date(
        today.getFullYear() + 12,
        today.getMonth(),
        today.getDay()
    );

    const todos = [
        { id: 1, description: "AWS", done: false, targetDate: targetDate },
        { id: 2, description: "Spring", done: false, targetDate: targetDate },
        { id: 3, description: "JPA", done: false, targetDate: targetDate },
    ];
    return (
        <div className="container">
            <h1>Todo</h1>
            <div>
                Todos
                <table className="table">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Description</td>
                            <td>Is Done</td>
                            <td>Target Date</td>
                        </tr>
                    </thead>
                    <tbody>
                        {todos.map((todo) => (
                            <tr key={todo.id}>
                                <td>{todo.id}</td>
                                <td>{todo.description}</td>
                                <td>{todo.done.toString()}</td>
                                <td>{todo.targetDate.toDateString()}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

function HeaderComponent() {
    return (
        <header className="border-bottom border-light border-5 mb-5 p-2">
            <div className="container">
                <div className="row">
                    <nav className="navbar navbar-expand-lg">
                        <pre className="navbar-brand ms-2 fs-2 fw-bold text-black">
                            Todo
                        </pre>
                        <div className="collapse navbar-collapse">
                            <ul className="navbar-nav">
                                <li className="nav-item fs-5">
                                    <Link
                                        className="nav-link"
                                        to="/welcome/todo"
                                    >
                                        Home
                                    </Link>
                                </li>
                                <li className="nav-item fs-5">
                                    <Link className="nav-link" to="/todos">
                                        Todos
                                    </Link>
                                </li>
                            </ul>
                        </div>
                        <ul className="navbar-nav">
                            <li className="nav-item fs-5">
                                <Link className="nav-link" to="/login">
                                    Login
                                </Link>
                            </li>
                            <li className="nav-item fs-5">
                                <Link className="nav-link" to="/logout">
                                    Logout
                                </Link>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
    );
}

function FooterComponent() {
    return (
        <footer className="footer">
            <div className="container">Footer</div>
        </footer>
    );
}

function LogoutComponent() {
    return (
        <div className="LogoutComponent">
            <h1>Logout</h1>
            <div>로그아웃되었습니다</div>
        </div>
    );
}
