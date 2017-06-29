/**
 * Created by User on 6/15/2017.
 */
function getAllWorkers() {
    const listOfWorkers = document.getElementById('dishWasher')
    const url = 'http://localhost:9000/rest/worker'
    fetch(url, {
        method: 'get',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then((response) => response.json())
        .then(function (data) {
            let workerList = ""
            for (let i = 0; i < data.length; i++) {
                workerList += `<select><option>${data[i].firstName} ${data[i].lastName}</option></select>`
            }
            listOfWorkers.innerHTML = workerList
        })
}
window.addEventListener('load', getAllWorkers)

function rdyToWash() {
    const dishAmount = document.getElementById('dishes').value
    const liquidAmount = document.getElementById('liquid').value
    const workerWork = document.getElementById('dishWasher').value
    const url = 'http://localhost:9000/rest/washer'
    fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            dishAmount,
            liquidAmount,
            workerWork,
        })
    })
        .then((response) => response.json())
        .then(function (data) {
            console.log(data)
        })
}

/*
 function answerSentence() {
 const text = document.getElementById("answer")
 const url = ''
 fetch(url, {
 method: 'get',
 headers: {
 'Content-type': 'application/json'
 },
 }).then((response) => response.json()
 ).then(function (answer) {
 //Mõelda välja funktsioon ja sisestada siis vastus
 return text.innerHTML = `testTEST tekst`; //textile parem nimi ja = märgi taha funktsiooni vastsus
 })
 }
 */
