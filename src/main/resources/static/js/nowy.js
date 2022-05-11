async function get() {
    await fetch('/testuje', {
        method: "GET"
    }).then(restReturnedValue => restReturnedValue.json())
        .then(valueJson => console.log(valueJson))
}

// const button = document.getElementById("nowyButton");
// button.addEventListener("click", get);


window.onload = function () {
    // let input = document.getElementById("quantity");
    let hiddenInput = document.getElementById("productID");
    let input = document.getElementsByClassName("quantityOfOrder");

    input.addEventListener('input', function (evt) {
        console.log(this.value);
        console.log(hiddenInput.value);

        fetch("/add_quantity/" + hiddenInput.value + '/' + this.value)
            .then(restReturnedValue => restReturnedValue.json())
            .then(valueJson => {
                let subtotal = document.getElementById("subtotal");
                subtotal.innerHTML = valueJson;
            })
    })
};

