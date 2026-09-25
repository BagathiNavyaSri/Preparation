import { useState } from "react";

function App() {
  const [transactionId, setTransactionId] = useState("");
  const [amount, setAmount] = useState("");
  const [transactionType, setTransactionType] = useState("TRANSFER");

  const [result, setResult] = useState<any>(null);

  const analyzeTransaction = async () => {
    const response = await fetch("http://localhost:8080/api/transactions", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        transactionId: transactionId,
        amount: Number(amount),
        transactionType: transactionType,
      }),
    });

    const data = await response.json();

    setResult(data);
  };

  return (
    <div>
      <h1>Transaction Analyzer</h1>

      <div>
        <label>Transaction ID</label>
        <br />
        <input
          value={transactionId}
          onChange={(e) => setTransactionId(e.target.value)}
          placeholder="TX1001"
        />
      </div>

      <br />

      <div>
        <label>Amount</label>
        <br />
        <input
          type="number"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          placeholder="25000"
        />
      </div>

      <br />

      <div>
        <label>Transaction Type</label>
        <br />

        <select
          value={transactionType}
          onChange={(e) => setTransactionType(e.target.value)}
        >
          <option value="TRANSFER">TRANSFER</option>
          <option value="PAYMENT">PAYMENT</option>
          <option value="WITHDRAWAL">WITHDRAWAL</option>
        </select>
      </div>

      <br />

      <button onClick={analyzeTransaction}>
        Analyze Transaction
      </button>

      {result && (
        <div>
          <h2>Result</h2>

          <p>Transaction ID: {result.transactionId}</p>
          <p>Risk Level: {result.riskLevel}</p>
          <p>{result.message}</p>
        </div>
      )}
    </div>
  );
}

export default App;