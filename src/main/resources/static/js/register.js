$(document).ready(function () {
  // on ready
});

async function registerUser() {
  let data = {};
  data.name = document.getElementById("txtName").value;
  data.last_name = document.getElementById("txtLast_name").value;
  data.email = document.getElementById("txtEmail").value;
  data.password = document.getElementById("txtPassword").value;

  let repeatPassword = document.getElementById("txtRepeatPassword").value;

  if (repeatPassword != data.password) {
    alert("The passwords do not match");
    return;
  }

  const request = await fetch("api/users", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  alert("The user was registered successfully");
  window.location.href = "login.html";
}
