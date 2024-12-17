$(function(){
    // icon set
    feather.replace();

    // datepicker
    $.fn.datepicker.dates['kr'] = {
        days: ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"],
        daysShort: ["일", "월", "화", "수", "목", "금", "토", "일"],
        daysMin: ["일", "월", "화", "수", "목", "금", "토", "일"],
        months: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
        monthsShort: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
        dateToLocalizedText: function(year, month){
            var date_str = '';
            date_str = year + '년 ';
            date_str = date_str + this.months[month];
            return date_str;
        }
    };

    // 에디터
    $('#summernote').summernote({
        lang: 'ko-KR',
        height: 300
    });
    $('#summernote2').summernote({
        lang: 'ko-KR',
        height: 300
    });

    $('.input-group.date').datepicker({
        calendarWeeks: false,
        todayHighlight: true,
        autoclose: true,
        toggleActive: false,
        format: "yyyy-mm-dd",
        language: "kr"
    });

    // clockpicker
    $('.clockpicker').clockpicker({
        autoclose: true
    });
});
