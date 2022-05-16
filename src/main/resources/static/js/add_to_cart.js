// function changeQuantity() {
//     let input = document.getElementById("quantity");
//     console.log(input);
//     let hiddenInput = document.getElementById("productID");
// // let input = document.getElementsByClassName("quantityOfOrder");
//
//     input.addEventListener('input', function (evt) {
//         console.log(this.value);
//         console.log(hiddenInput.value);
//
//         fetch("/add_quantity/" + hiddenInput.value + '/' + this.value)
//             .then(restReturnedValue => restReturnedValue.json())
//             .then(valueJson => {
//                 let subtotal = document.getElementById("subtotal");
//                 subtotal.innerHTML = valueJson;
//             })
//     })
// }

function changeCartSizeValueInBadge() {
    let badgeElement = document.getElementById("badge");
    changeBadgeColor(badgeElement);


    fetch("/shopping_cart_size")
        .then(value => value.json())
        .then(valueJson => {
            badgeElement.innerHTML = valueJson;
        });

}

function changeBadgeColor(badgeElement) {
    badgeElement.classList.remove("badge-secondary");
    badgeElement.classList.add("badge-danger");

    setTimeout(function () {
        badgeElement.classList.remove("badge-danger");
        badgeElement.classList.add("badge-secondary")
    }, 800);
}

const addToCart = document.getElementsByClassName("btn-success");

function addingToCart() {
    for (let i = 0; i < addToCart.length; i++) {

        addToCart.item(i).addEventListener('click', function (evt) {

            fetch("/add_to_cart/" + addToCart.item(i).name)
                .then(product => product.json())
                .then(valueJson => console.log(valueJson));

        })

        addToCart[i].addEventListener('click', changeCartSizeValueInBadge);
    }
}

window.onload = function () {
    addingToCart();

}