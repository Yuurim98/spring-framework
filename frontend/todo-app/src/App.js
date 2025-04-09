import "./App.css";
import { Component } from "react";

function App() {
    return (
        <div className="App">
            <FirstComponent />
            <SecondComponent />
            <ThirdComponent />
        </div>
    );
}

function FirstComponent() {
    return <div className="firstComponent">첫번째 컴포넌트</div>;
}

function SecondComponent() {
    return <div className="secondComponent">두번째 컴포넌트</div>;
}

class ThirdComponent extends Component {
    render() {
        return <div className="thirdComponent">세번째 컴포넌트</div>;
    }
}

export default App;
