let lockicon = document.getElementById('lockicon');
let password = document.getElementById('password');

lockicon.onclick = function () {
    if (password.type == 'password') {
        password.type = 'text';
        lockicon.className = 'bx bx-lock-open-alt';
    } else {
        password.type = 'password';
        lockicon.className = 'bx bx-lock-alt'
    }
}