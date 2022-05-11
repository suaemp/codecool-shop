

async function get() {
    await fetch('/testuje', {
        method: "GET"
    }).then(restReturnedValue => restReturnedValue.json() )
        .then(valueJson => console.log(valueJson))
}

const button = document.getElementById("nowyButton");
button.addEventListener("click", get);