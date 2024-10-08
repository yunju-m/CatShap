const regex = {
    usid: /^[A-Za-z0-9]{4,16}$/, // 아이디
    uname: /^[가-힣a-zA-Z]+$/, // 이름
    unick: /^[가-힣a-zA-Z0-9_]{2,10}$/, // 닉네임
    email: /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/, // 이메일
    uphone: /^\d{10,11}$/, // 휴대전화
    uauthcode: /^\d{6}$/, // 비밀번호 찾기 인증코드
    upasslength: /^.{8,16}$/, // 비밀번호 길이:  8~16
    lowerCase: /[a-z]/, // 소문자
    upperCase: /[A-Z]/, // 대문자
    number: /\d/, // 숫자
    specialChar: /[@!$%^&*()_+{}\[\]:;"'<>,.?/~`]/ // 특수문자
};

// 입력여부 확인 함수
const validateField = (selector, errorSelector, errorMessage) => {
    const value = $(selector).val().trim();
    if (value === '') {
        $(errorSelector).text(errorMessage).show();
        return false;
    } else {
        $(errorSelector).hide();
        return true;
    }
} 

// 정규표현식을 통한 형식 확인 함수
const validateFormat = (selector, errorSelector, errorMessage, pattern) => {
    const value = $(selector).val().trim(); 
    if (!pattern.test(value)) {
        $(errorSelector).text(errorMessage).show();
        return false;
    } else {
        $(errorSelector).hide();
        return true;
    }
}