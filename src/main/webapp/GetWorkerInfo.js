/**
 * Created by User on 6/15/2017.
 */
function getAllWorkers() {
    const ul = document.getElementById('dishWasher')
    const url = 'http://localhost:9000/rest/worker'
    fetch(url, {
        method: 'get',
        headers: {
            'Content-Type': 'application/json'
        },
    }).then((response) => response.json()
    ).then(function (data) {
        let workerList = ""
        for (let i = 0; i < data.length; i++) {
            workerList += `<select><option>${data[i].firstName} ${data[i].lastName}</option></select>`
        }
        return ul.innerHTML = workerList

    })
}
getAllWorkers()