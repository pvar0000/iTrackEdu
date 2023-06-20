// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#users').DataTable();
});

async function loadUsers() {
    const request = await fetch("user/1564", {
        method: "GET",
        headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
        },
    });

     const users = await request.json();

     let listHtml = '';
     for (let user of users) {
        let userHtml = '<tr><td>' + users.id + '</td><td>' + users.name + ' ' + users.last_name + '</td><td>' + users.email + '</td><td>' + users.password + '</td><td>' +  buttonDelete + '</td></tr>';
        listHtml += userHtml;
     }
     let buttonDelete = '<a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    document.querySelector('#users tbody').outerHTML = userHtml;
