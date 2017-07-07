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
            let washerList = ""
            for (let i = 0; i < data.length; i++) {
                washerList += `<select><option>${data[i].firstName} ${data[i].lastName}</option></select>`
            }
            listOfWorkers.innerHTML = washerList
        })
}
window.addEventListener('load', getAllWorkers)

document.getElementById("wash").addEventListener("click", readyToWash)

function readyToWash() {
    const dishAmount = document.getElementById("dishes").value
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

            document.getElementById("answer").innerHTML = data.answer
        })
}