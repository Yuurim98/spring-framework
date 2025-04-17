import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function LoginComponent() {
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
