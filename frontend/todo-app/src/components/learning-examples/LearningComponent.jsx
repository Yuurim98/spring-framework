import FirstComponent from "./FirstComponent";
import SecondComponent from "./SecondComponent";
import ThirdComponent from "./ThirdComponent";
import { FourthComponent } from "./FirstComponent";
import { Component } from "react";

export default function LearningComponent() {
    return (
        <div className="App">
            <FirstComponent />
            <SecondComponent />
            <ThirdComponent />
            <FourthComponent />
        </div>
    );
}
