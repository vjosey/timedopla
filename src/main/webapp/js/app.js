//var req = new XMLHttpRequest();

//req.open('GET','')

//let username = document.getElementById('username');

//username.innerText ='Mebobgotabadyitsaboy';

document.addEventListener('DOMContentLoaded', function(){

    
    let url = 'http://localhost:8080/Timedopla/api/user';
    let promise = axios.get(url);

    promise.then(function(response){
            //let response = 
           // appendArtist(response.data);
           // document.getElementById('artist').value =null;
           window.alert(response.data);

           appendUser(response.data);
    });
} )


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
    name.innerText = user.username;
    tr.appendChild(id);
    tr.appendChild(name);
    document.getElementById('list').appendChild(tr);
}
