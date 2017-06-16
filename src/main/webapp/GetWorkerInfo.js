/**
 * Created by User on 6/15/2017.
 */
function getAllWorkers() {
    fetch('http://localhost:9000/rest/worker', {
        method: 'get',
        headers: {
            'Content-Type': 'application/json'
        },
    }).then((response) => response.json())
        .then((data) =>
            console.log(data)
        )
}
getAllWorkers()