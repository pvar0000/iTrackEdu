// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadUsers();
  $("#users").DataTable();
});

async function loadUsers() {
    const request = await fetch("api/users", {
        method: "GET",
        headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
        },
    });

     const users = await request.json();

     let listUsersHtml = '';
     for (let user of users) {
        let buttonDelete = '<a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let userHtml = '<tr><td>' + user.id + '</td><td>' + user.name + ' ' + user.last_name + '</td><td>' + user.email + '</td><td>' + user.password + '</td><td>' +  buttonDelete + '</td></tr>';
        listUsersHtml += userHtml;
     }

    document.querySelector('#users tbody').outerHTML = listUsersHtml;
}
