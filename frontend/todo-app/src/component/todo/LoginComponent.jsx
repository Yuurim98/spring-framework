import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function LoginComponent() {
    const [username, setUsername] = useState("test-name");
    const [password, setPassword] = useState("");
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const navigate = useNavigate();
    const authContext = useAuth();

    function handleUsernameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function handleSubmit() {
        if (authContext.login(username, password)) {
            navigate(`/welcome/${username}`);
        } else {
            setShowErrorMessage(true);
        }
    }

    return (
        <div className="Login">
            <h1>Login</h1>
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
