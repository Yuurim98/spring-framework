import { useState } from "react";
import "./Counter.css";

export default function Counter() {
    const [count, setCount] = useState(0);

    function incrementCounterFunction() {
        console.log("증가 버튼 클릭");
        setCount(count + 1);
        console.log(count);
    }

    function decrementCounterFunction() {
        console.log("감소 버튼 클릭");
        setCount(count - 1);
    }
    return (
        <div className="Counter">
            <span className="count">{count}</span>
            <div>
                <button
                    className="counterButton"
                    onClick={incrementCounterFunction}
                >
                    +1
                </button>
                <button
                    className="counterButton"
                    onClick={decrementCounterFunction}
                >
                    -1
                </button>
            </div>
        </div>
    );
}
