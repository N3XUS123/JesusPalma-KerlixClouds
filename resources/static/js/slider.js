$('#prev').on('click', function() {
    var last = $('.slider-element').last().css({ opacity: '0' });
    last.prependTo('.slider-list');
    last.animate({ opacity: '1' });
});
$('#next').on('click', function() {
    var first = $('.slider-element').first();
    first.animate({ opacity: '0' }, function() {
        first.appendTo('.slider-list').css({ opacity: '1' });
    });
});