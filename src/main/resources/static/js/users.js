// Call the dataTables jQuery plugin
$(document).ready(function () {
  loadUsers();
  $("#users").DataTable();
});

async function loadUsers() {
  const request = await fetch("api/users", {
    method: "GET",
    headers: getHeaders(),
  });

  const users = await request.json();

  let listUsersHtml = "";
  for (let user of users) {
    let buttonDelete =
      '<a href="#" onclick="deleteUser(' +
      user.id +
      ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let userHtml =
      "<tr><td>" +
      user.id +
      "</td><td>" +
      user.name +
      " " +
      user.last_name +
      "</td><td>" +
      user.email +
      "</td><td>" +
      user.password +
      "</td><td>" +
      buttonDelete +
      "</td></tr>";
    listUsersHtml += userHtml;
  }

  document.querySelector("#users tbody").outerHTML = listUsersHtml;
}

function getHeaders() {
  return {
    Accept: "application/json",
    "Content-Type": "application/json",
    Authorization: localStorage.token,
  };
}

async function deleteUser(id) {
  if (!confirm("Are you sure you want to delete it?")) return;

  const request = await fetch("api/users/" + id, {
    method: "DELETE",
    headers: getHeaders(),
  });

  location.reload();
}
