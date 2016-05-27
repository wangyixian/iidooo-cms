/**
 * Created by Ethan on 16/5/26.
 */

jQuery(document).ready(function() {

    /*
     Fullscreen background
     */
    $.backstretch("../img/login/bg.jpg");

    /*
     Form validation
     */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
        $(this).removeClass('input-error');
    });

    $('.login-form').on('submit', function(e) {

        $(this).find('input[type="text"], input[type="password"], textarea').each(function(){
            if( $(this).val() == "" ) {
                e.preventDefault();
                $(this).addClass('input-error');
            }
            else {
                $(this).removeClass('input-error');
            }
        });

    });


});