import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import HeaderComponent from "./HeaderComponent";
import LoginComponent from "./LoginComponent";
import LogoutComponent from "./LogoutComponent";
import ListTodosComponent from "./ListTodosComponent";
import WelcomeComponent from "./WelcomeComponent";
import ErrorComponent from "./ErrorComponent";
import FooterComponent from "./FooterComponent";
import AuthProvider, { useAuth } from "./security/AuthContext";
import "./TodoApp.css";

function AuthencatedRoute({ children }) {
    const authContext = useAuth();
    if (authContext.isAuthenticated) {
        return children;
    }

    return <Navigate to="/" />;
}

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path="/" element={<LoginComponent />} />
                        <Route path="/login" element={<LoginComponent />} />
                        <Route
                            path="/welcome/:username"
                            element={
                                <AuthencatedRoute>
                                    <WelcomeComponent />
                                </AuthencatedRoute>
                            }
                        />
                        <Route
                            path="/todos"
                            element={
                                <AuthencatedRoute>
                                    <ListTodosComponent />
                                </AuthencatedRoute>
                            }
                        />
                        <Route
                            path="/logout"
                            element={
                                <AuthencatedRoute>
                                    <LogoutComponent />
                                </AuthencatedRoute>
                            }
                        />
                        <Route path="*" element={<ErrorComponent />} />
                    </Routes>
                    <FooterComponent />
                </BrowserRouter>
            </AuthProvider>
        </div>
    );
}
