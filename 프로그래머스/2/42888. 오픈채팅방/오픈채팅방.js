// 가상의 닉네임을 사용 가능한 오픈채팅방
// [닉네임]님이 들어왔습니다.
// [닉네임]님이 나갔습니다.
// 닉네임 변경 방법 
// 1. 채팅방 나가고, 새로운 닉네임으로 재입장 
// 2. 채팅방에서 닉네임 변경
// 1과 2를 이용한 닉네임 변경 시 기존 채팅의 닉네임도 전부 변경

// 닉네임 변경한 기록이 담긴 문자열 배열 record
function solution(record) {
    const splited = new Map();
    const result = [];
    
    record.map((el) => {
        const [action, id, name] = el.split(" ");
        if(action === "Enter" || action === "Change") {
            splited.set(id, name);
        }
    });
    
    record.map((el) => {
        const [action, id] = el.split(" ");
        if(action === "Enter") {
            result.push(`${splited.get(id)}님이 들어왔습니다.`);
        } else if(action === "Leave") {
            result.push(`${splited.get(id)}님이 나갔습니다.`);
        }
    })
    
    
    return result;
}