import { useState } from "react";
import { PropTypes } from "prop-types";
import "./Counter.css";

export default function Counter({ by = 1 }) {
    const [count, setCount] = useState(0);

    function incrementCounterFunction() {
        console.log("증가 버튼 클릭");
        setCount(count + by);
        console.log(count);
    }

    function decrementCounterFunction() {
        console.log("감소 버튼 클릭");
        setCount(count - by);
    }
    return (
        <div className="Counter">
            <span className="count">{count}</span>
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

Counter.propTypes = {
    by: PropTypes.number,
};
