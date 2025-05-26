const rollDiceButton = document.getElementById("rollButton");
const diceImageDiv = document.getElementById("diceImageDiv");
const submissionDiv = document.getElementById("submissionDiv");
const submissionForm = document.getElementById("submissionForm");
const nameInput = document.getElementById("nameInput");

let currentRoll = 0;

submissionDiv.classList.add("hidden");

if (currentRoll !== 0){
    submissionDiv.classList.remove("hidden")
}

async function rollDice() {
    const response = await fetch("api/roll", {
        method: "GET",
        types: "json"
    })
    if (response.ok) {
        currentRoll = await response.json();
        console.log(currentRoll);

        // Clear existing image
        diceImageDiv.innerHTML = "";

        // Create and append new image element
        const img = document.createElement("img");
        img.src = `images/diceFaces/${currentRoll}.png`;
        img.alt = `Dice face showing ${currentRoll}`;
        img.width = 100; // Optional: set image size
        img.height = 100;

        diceImageDiv.appendChild(img);
        submissionDiv.classList.remove("hidden")
    }
}

async function submitScore() {
    const response = await fetch("api/save", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            rolledNumber: currentRoll,
            name: nameInput.value.trim()
        })
    });
    if (response.status === 201) {
        console.log("Success!");
        currentRoll = 0;
        window.location.reload();
    } else {
        console.log("Fail");
    }
}


rollDiceButton.addEventListener("click", rollDice);
submissionForm.addEventListener("submit", async function(e)
{
    e.preventDefault();
    if (nameInput.value.trim() !== "" && currentRoll !== 0) {
        await submitScore();
    }

})