/**
 * Created by User on 7/10/2017.
 */
document.getElementById("addNewWorker").addEventListener("click", addWorker)

function addWorker(){
    const firstName = document.getElementById("firstName").value
    const lastName = document.getElementById("lastName").value
    const efficiency = document.getElementById("efficiency").value
    const url = 'http://localhost:9000/rest/newWorker'
    fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            firstName,
            lastName,
            efficiency,
        })
    })
        //.then((response) => response.json())
/*        .then(function (data){

            return data
        })*/
}

function showWorkerTable(){
    const tableContent = document.getElementById('workerDataTable')
    const url = 'http://localhost:9000/rest/worker'
    fetch(url, {
        method: 'get',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then((response) => response.json())
        .then(function (data){
            let workerTable = ""
            for(let i = 0; i < data.length; i++){
                workerTable += `<tr><td>${data[i].firstName}</td>
                                    <td>${data[i].lastName}</td>
                                    <td>${data[i].efficiency}</td>
                                    <td>${data[i].id}</td></tr>`
            }
            tableContent.innerHTML = workerTable
        })
}
window.addEventListener('load', showWorkerTable)