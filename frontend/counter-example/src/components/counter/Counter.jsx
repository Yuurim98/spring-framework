import { useState } from "react";
import "./Counter.css";
import CounterButton from "./CounterButton";
import ResetButton from "./ResetButton";

export default function Counter() {
    const [count, setCount] = useState(0);

    function incrementCounterParentFunction(by) {
        setCount(count + by);
    }

    function decrementCounterParentFunction(by) {
        setCount(count - by);
    }

    function resetConter() {
        setCount(0);
    }

    return (
        <>
            <CounterButton
                incrementMethod={incrementCounterParentFunction}
                decrementMethod={decrementCounterParentFunction}
            />
            <CounterButton
                by={3}
                incrementMethod={incrementCounterParentFunction}
                decrementMethod={decrementCounterParentFunction}
            />
            <CounterButton
                by={5}
                incrementMethod={incrementCounterParentFunction}
                decrementMethod={decrementCounterParentFunction}
            />
            <span className="totalCount">{count}</span>
            <ResetButton resetMethod={resetConter} />
        </>
    );
}
