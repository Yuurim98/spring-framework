export default function ResetButton({ resetMethod }) {
    return (
        <div>
            <button className="resetButton" onClick={resetMethod}>
                reset
            </button>
        </div>
    );
}
