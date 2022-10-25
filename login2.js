function mostrarCadastro() {
    document.querySelector('.card').style.display='none';
    document.querySelector('.card-cadastro').style.display='block';
}

function cadastrar(){
    emailCad = document.querySelector('#email');
    senhaCad = document.querySelector('#senha');
    confirmSenhaCad = document.querySelector('#confirmSenha').value;

    if(emailCad.value.trim() == "" || senhaCad.value.trim() == "" || confirmSenhaCad.trim() == "") {
        window.alert("Dados inválidos")
    } else {

        if(senhaCad.value == confirmSenhaCad) {
            fetch("http://localhost:8090/cadastrar", 
            {
                method: "POST",
                headers: {
                    "Accept" : "application/json",
                    "Content-Type" : "application/json",
                },

                body: JSON.stringify({
                    email : emailCad.value,
                    senha : senhaCad.value
                })
            })

            .then(function(res) {if (res.status=200){alert ("Cadastro realizado")}})
            .catch(function(res) {console.log(res)})

        } else {
            window.alert("Dados incorretos")
        }
    }
}
function entrar(){
    let emailL = document.querySelector('#emailL').value;
    let senhaL = document.querySelector('#senhaL').value;

    if(emailL.trim() == "" || senhaL.trim() == "") {
        window.alert("Dados inválidos")
        if(emailL == "m@gmail.com" && senhaL == "1234"){
            location.href = "index.html"
    } 
    }

    
}