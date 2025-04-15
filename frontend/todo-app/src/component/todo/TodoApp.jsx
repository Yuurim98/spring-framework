import { useState } from "react";
import "./TodoApp.css";

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <LoginComponent />
            {/* <WelcomeComponent /> */}
        </div>
    );
}

function LoginComponent() {
    const [username, setUsername] = useState("test-name");
    const [password, setPassword] = useState("");
    const [showSuccessMessage, setShowSuccessMessage] = useState(false);
    const [showErrorMessage, setShowErrorMessage] = useState(false);

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
        } else {
            setShowSuccessMessage(false);
            setShowErrorMessage(true);
        }
    }

    return (
        <div className="Login">
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

// function WelcomeComponent() {
//     return <div className="Welcome">Welcome 컴포넌트</div>;
// }
