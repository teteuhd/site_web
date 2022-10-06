const form = document.getElementById('form');
const email = document.getElementById('email');
const senha = document.getElementById('senha');

form.addEventListener('submit', function(e) {
    e.preventDefault();
});

function logar() {
    location.href = "index.html"
}


