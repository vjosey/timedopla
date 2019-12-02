
var currentTimeSheet = {
id: '',
totalHours: '',
sunday: '',
monday: '',
tuesday:'',
wednesday:'',
thurdays:'',
friday:''
};


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



window.addEventListener('DOMContentLoaded', pageState);

function pageState(){
//console.log("call window");
switch(location.hash)
{
    case '#dashboard':
        dashboard();
    break;
    case '#login':
        login();
    break;
    case '#timesheet':
        timeSheetPage();
    break;
    case '#profile':
    break;

}

}


//console.log(location.hash); // testing

function login(){
var userSignForm = document.getElementById('user-signin-form');

if(userSignForm != null)
{
    userSignForm.addEventListener('submit', function(e){
    e.preventDefault(); // stop expecting a page refresh


    let user = {
        userName: document.getElementById('inputUser').value,
        gatecode: document.getElementById('inputPassword').value
    };

    let url = 'http://localhost:8080/Timedopla/api/session';

    let promise = axios.post(url, user);

    promise.then(function(response){
            
            console.log(response.data.userId);

            // clear out username and password input fields 
            document.getElementById('inputUser').value =null;
            document.getElementById('inputPassword').value =null;
            location.hash = "#dashboard";
            dashboard();
           
    });

    promise.catch(function(){

    });

});
}else{
    //location.reload();
}

console.log(userSignForm);
}


function dashboard()
{
   getUser(dashboardInfo);
   getTimeSheets();
}

document.getElementById('logout').addEventListener('click', function(){
    let url = 'http://localhost:8080/Timedopla/api/logout';
    let promise = axios.get(url);
    location.hash = "#login";
});


function getUser(func)
    {

    let url = 'http://localhost:8080/Timedopla/api/user';
    let promise = axios.get(url).then(resp => {
        console.log(resp.data);
        func(resp.data);
    });

}

function getTimeSheets()
    {

    let url = 'http://localhost:8080/Timedopla/api/timesheet';
    let promise = axios.get(url).then(resp => {
        console.log("Get timesheets");
        timeSheetSep(resp.data);
    });

}

function getTimeSheet(id)
    {

    let url = `http://localhost:8080/Timedopla/api/timesheet?id=${id}`;

    let promise = axios.get(url).then(resp => {
        console.log("Get timesheets  " + url);
       
    });

}



function dashboardInfo(data)
{
    let uin = document.getElementById("profileimg");
    uin.innerText = data.userInitials;
}

function timeSheetSep(list){
    for(let sheet of list){
        appendListTimesheets(sheet);
    }
}

function appendListTimesheets(sheet){
    let tr = document.createElement('tr');

    let dateTs = document.createElement('td');
    dateTs.innerText = sheet.startOfWeek;

    let hourTs= document.createElement('td');
    hourTs.innerText = sheet.totalHours + " hr(s)";

    let statusTs= document.createElement('td');
    statusTs.innerText = sheet.status;

    let buttonTstd= document.createElement('td');
    let buttonTs = document.createElement('button');
    buttonTs.setAttribute('id','btn'+sheet.timesheetId);
    buttonTs.setAttribute('class','btnbtn btn-primary btn-block');
   
    if(sheet.status == "Saved" || sheet.status == "Denied")
    {
        buttonTs.innerText = "Edit";
        buttonTs.setAttribute('onclick',`onTimeSheetCall(${sheet.timesheetId},"Edit")`);

    }else if(sheet.status == "Approved" || sheet.status == "Submitted")
    {
        buttonTs.innerText = "View";
        buttonTs.setAttribute('onclick',`onTimeSheetCall(${sheet.timesheetId},"View")`);
    }

    tr.appendChild(dateTs);
    tr.appendChild(hourTs);
    tr.appendChild(statusTs);
    tr.appendChild(buttonTstd);
    buttonTstd.appendChild(buttonTs);

    document.getElementById('timesheetList').appendChild(tr);
}

function onTimeSheetCall(tsId, tsStat)
{
    // get timesheet by id 
    getTimeSheet(tsId);

 if(tsStat=="Edit")
 {
    // load timesheet page with editable elements
   // console.log("Edit Timesheet");
   location.hash = "#timesheet";

   location
 }else if(tsStat=="View"){
     // load timesheet page with viewable elements
    // console.log("View Timesheet");

    location.hash = "#timesheet";
 }

 //location.reload();
}


function timeSheetPage()
{
    timesheetDayRow('sunday');
    timesheetDayRow('monday');
    timesheetDayRow('tuesday');
    timesheetDayRow('wednesday');
    timesheetDayRow('thurdays');
    timesheetDayRow('friday');
    timesheetDayRow('saturday');
}

function appendPunchCard()
{


}

function timesheetDayRow(name)
{
    let row = document.createElement("div");
    row.setAttribute('class','row');
    row.setAttribute('id', name);
    
    timesheetDayColLabel(name, name, row);
    timesheetDayCol("inAm" + name,"In",row);
    timesheetDayCol("outAm"+ name,"Out",row);
    timesheetDayCol("inPm" + name,"In",row);
    timesheetDayCol("outPm"+ name,"Out",row);
    timesheetDayColLabel(name + "hours", "40hr(s)", row);


let form = document.getElementById('puchcardTime');
form.appendChild(row);

}

function timesheetDayCol(name,disTxt,parent)
{
    let col = document.createElement("div");
    col.setAttribute('class','col');
    col.setAttribute('id', name);

    let timeInput = document.createElement('input');
    timeInput.setAttribute('type','text');
    timeInput.setAttribute('class','form-control');
    timeInput.setAttribute('placeholder',disTxt);
    
    col.appendChild(timeInput);
    parent.appendChild(col);
}

function timesheetDayColLabel(name, msg, parent)
{
    let col = document.createElement("div");
    col.setAttribute('class','col');
    col.setAttribute('id', name);

    let title = document.createElement('h5');
    title.setAttribute('class','text-uppercase');
   // title.setAttribute('placeholder',name);
    
   title.innerText = msg;
    col.appendChild(title);
    parent.appendChild(col);
}


function setCurrentTimeSheet(data)
{
    currentTimeSheet.id = data.timesheetId; 
    currentTimeSheet.sunday = data;
    currentTimeSheet.monday = data.monPcard.;
    currentTimeSheet.tuesday = data;
    currentTimeSheet.wednesday = data;
    currentTimeSheet.thurdays = data;
    currentTimeSheet.friday =data;

    currentTimeSheet.totalHours = data; 
}


