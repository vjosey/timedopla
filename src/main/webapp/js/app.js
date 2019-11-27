//var req = new XMLHttpRequest();

//req.open('GET','')

//let username = document.getElementById('username');

//username.innerText ='Mebobgotabadyitsaboy';

document.addEventListener('DOMContentLoaded', function(){

    
    let url = 'http://localhost:8080/Timedopla/api/user';



    axios.get(url).then(resp => {
    
        console.log(resp.data);
         Userstatic(resp.data);
    });

})


function Userstatic(list){
    for(let user of list){
        appendUser(user);
    }
}
function appendUser(user){
    let tr = document.createElement('tr');
    let id= document.createElement('td');

    id.innerText = user.userId;

    let name = document.createElement('td');
    name.innerText = user.userName;
    tr.appendChild(id);
    tr.appendChild(name);
    document.getElementById('list').appendChild(tr);
}
