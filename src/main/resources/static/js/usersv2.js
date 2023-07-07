// Call the dataTables jQuery plugin
$(document).ready(function () {
  loadGrades();
});

async function loadGrades() {
  let data = {};
  data.email = document.getElementById("txtEmail").value;
  data.password = document.getElementById("txtPassword").value;

  const request = await fetch("api/grades/", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });

  const grades = await request.json();
}

function getHeaders() {
  return {
    Accept: "application/json",
    "Content-Type": "application/json",
    Authorization: localStorage.token,
  };
}
