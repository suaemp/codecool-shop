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


function changeBudgeColor() {
    let element = document.getElementById("badge");
    element.classList.remove("badge-secondary")
    element.classList.add("badge-danger");
}

const addToCart = document.getElementsByClassName("btn-success");
for (let i = 0; i < addToCart.length; i++) {
    addToCart[i].addEventListener('click', changeBudgeColor)
}
;


// window.onload = function () {
//     let addToCartButton = document.getElementById("add-to-cart");
//     let addToCartButtons = document.getElementsByClassName("btn-success");
//
//     for (let i = 0; i < addToCartButtons.length; i++) {
//         console.log(addToCartButtons.item(i));
//
//         addToCartButtons.item(i).addEventListener('anchor', function (evt) {
//             console.log("HELLO");
//             fetch("/add_to_cart/" + addToCartButtons.item(i).name)
//                 .then(product => product.json())
//                 .then(valueJson => console.log(valueJson));
//         })
//     }
//
// }
const addToCartButtons = document.getElementsByClassName("btn-success");
window.onload = function () {
    let addToCartButton = document.getElementById("add-to-cart");
    console.log(addToCartButtons.item(1));

    for (let i = 0; i < addToCartButtons.length; i++) {
        addToCartButtons.item(i).addEventListener('click', addToCartAction);
    }

}

function addToCartAction() {
    for (let i = 0; i < addToCartButtons.length; i++) {
        fetch("/add_to_cart/" + addToCartButtons.item(i).name)
            .then(product => console.log(product))
            .then(valueJson => console.log(valueJson));
    }
}

