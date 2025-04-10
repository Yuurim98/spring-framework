import "./App.css";
import Counter from "./components/counter/Counter";

function App() {
    return (
        <div className="App">
            <Counter />
            <Counter by={3} />
            <Counter by={5} />
        </div>
    );
}

// function PlayingWithProps(properties) {
//     console.log(properties);

//     return <div>Props</div>;
// }

// function PlayingWithProps({ property1, property2 }) {
//     console.log(property1);
//     console.log(property2);

//     return <div>Props</div>;
// }
export default App;
