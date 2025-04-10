import { useState } from "react";
import { PropTypes } from "prop-types";
import "./Counter.css";

export default function Counter() {
    const [count, setCount] = useState(0);

    function incrementCounterParentFunction(by) {
        setCount(count + by);
    }

    function decrementCounterParentFunction(by) {
        setCount(count - by);
    }

    return (
        <>
            <span className="totalCount">{count}</span>
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
        </>
    );
}

function CounterButton({ by = 1, incrementMethod, decrementMethod }) {
    function incrementCounterFunction() {
        incrementMethod(by);
    }

    function decrementCounterFunction() {
        decrementMethod(by);
    }
    return (
        <div className="Counter">
            <div>
                <button
                    className="counterButton"
                    onClick={incrementCounterFunction}
                >
                    +{by}
                </button>
                <button
                    className="counterButton"
                    onClick={decrementCounterFunction}
                >
                    -{by}
                </button>
            </div>
        </div>
    );
}

CounterButton.propTypes = {
    by: PropTypes.number,
};
