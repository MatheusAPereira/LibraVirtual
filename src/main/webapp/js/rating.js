document.addEventListener('DOMContentLoaded', (event) => {
    const starContainer = document.getElementById('stars');
    const stars = starContainer.getElementsByTagName('span');
    const ratingGuides = document.getElementById('guides');
    const ratingText = document.getElementById('rating-text');
    const ratings = {
        "0.5": "Horrível",
        "1.0": "Muito ruim",
        "1.5": "Ruim",
        "2.0": "Fraco",
        "2.5": "Regular",
        "3.0": "Legal",
        "3.5": "Bom",
        "4.0": "Muito bom",
        "4.5": "Ótimo",
        "5.0": "Obra-prima"
    };
    let userRating = 0;
    let lastUserRating = 0;

    ratingGuides.addEventListener('mouseover', function(e) {
        if(userRating != 0){
            lastUserRating = userRating;
            userRating = 0;
        }
        if(e.target.matches('div')) {
            let rating = e.target.dataset.value;
            ratingText.textContent = ratings[rating];

            console.log('Muito, muito antes: '+rating);
            showStars(rating);
        }
    });

    ratingGuides.addEventListener('mouseout', function(e) {
        if(lastUserRating != 0 && userRating == 0) {
            userRating = lastUserRating;
            ratingText.textContent = ratings[userRating];
        }
        if (userRating == 0){
            ratingText.textContent = '';

            for (i = 0; i < stars.length; i++) {
                stars[i].classList.remove('bi-star-fill');
                stars[i].classList.remove('bi-star-half');
                stars[i].classList.add('bi-star');
            }
        }
        ratingText.textContent = ratings[userRating];
    });

    ratingGuides.addEventListener('click', function(e) {
        if(e.target.matches('div')) {
            userRating = e.target.dataset.value;
            console.log(userRating);
        }
    });

    function showStars(rating) {
        console.log('Muito antes: '+rating);

        switch (rating) {
            case 0.5:
                stars[0].classList.remove('bi-star');
                stars[0].classList.add('bi-star-half');
                break;
            case 1.5:
                stars[0].classList.remove('bi-star');
                stars[0].classList.add('bi-star-fill')
                stars[1].classList.remove('bi-star').add('bi-star-half');
                break;
        }

        /*
        if (rating % 1 != 0) {
            if (rating - 0.5 == 0){
                stars[0].classList.remove('bi-star');
                stars[0].classList.add('bi-star-half');
            } else {
                console.log('antes: '+rating);
                for (i = 0; i <= rating; i++) {
                    stars[i].classList.remove('bi-star');
                    stars[i].classList.add('bi-star-fill');
                }
                console.log('Depois: '+rating);
                console.log(rating + 1);
                stars[rating + 1].classList.remove('bi-star');
                stars[rating + 1].classList.add('bi-star-half');
            }

        } else {
            for (i = 0; i < rating; i++) {
                stars[i].classList.remove('bi-star');
                stars[i].classList.add('bi-star-fill');
            }
        }
        */
    }
});