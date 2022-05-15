// async function get() {
//     await fetch('/testuje', {
//         method: "GET"
//     }).then(restReturnedValue => restReturnedValue.json())
//         .then(valueJson => console.log(valueJson))
// }
//
// const button = document.getElementById("nowyButton");
// button.addEventListener("click", get);


window.onload = function () {
    let input = document.getElementById("quantity");
    console.log(input);
    let hiddenInput = document.getElementById("productID");
    // let input = document.getElementsByClassName("quantityOfOrder");

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

//
// function changeBudgeColor() {
//     let element = document.getElementById("badge");
//     element.classList.remove("badge-secondary")
//     element.classList.add("badge-danger");
// }
//
// const addToCart = document.getElementsByClassName("btn-success");
// for (let i = 0; i < addToCart.length; i++) {
//     addToCart[i].addEventListener('click', changeBudgeColor)
// }
// ;
//
//
// window.onload = function () {
//
//     let addToCart = document.getElementsByClassName("btn-success");
//
//     for (let i = 0; i < addToCart.length; i++) {
//
//         addToCart.item(i).addEventListener('click', async function (evt) {
//
//             await fetch("/add_to_cart/" + addToCart.item(i).name)
//                 .then(product => product.json())
//                 .then(valueJson => console.log(valueJson));
//         })
//     }
//
// }


