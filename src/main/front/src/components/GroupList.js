/* GroupList.js */
import React, {useEffect, useState} from 'react';
import "./GroupList.css";
import {useNavigate, useParams} from "react-router-dom";
import {Link} from 'react-router-dom';
import GroupMembers from './GroupMembers';


const GroupList = () => {
    const [groups, setGroups] = useState([]);
    const [boxVisible, setBoxVisible] = useState(false);
    const [groupDetail, setGroupDetail] = useState(false);
    const [groupNewMember, setGroupNewMember] = useState(false);
    const [groupName, setGroupName] = useState('');
    const [memberName, setMemberName] = useState('');
    const [groupMembers, setGroupMembers] = useState([]);
    const [groupExists, setGroupExists] = useState(true); // 그룹이 존재하는지 여부 상태 추가
    const [errorMessage, setErrorMessage] = useState(''); // 오류 메시지 상태 추가
    const history = useNavigate();

    const {idx} = useParams();
    const [loading, setLoading] = useState(true);
    const [group, setGroup] = useState({});

    // 그룹 정보 가져오는 함수
    const fetchGroupDetail = (groupId) => {
        fetch(`/api/lol/groups/${groupId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then((response) => response.json())
            .then((data) => setGroup(data))
            .catch((error) => {
                console.error('데이터를 가져오는 중 오류가 발생했습니다:', error);
            })
            .finally(() => {
                setLoading(false);
            });
    };

    // useEffect(() => {
    //     fetchGroupDetail(); // 처음 렌더링될 때 그룹 정보를 가져옴
    // }, []);

    const handleDeleteMember = (groupId, memberGameId) => {
        // 확인 다이얼로그 표시
        const isConfirmed = window.confirm(`정말로 해당 멤버를 삭제하시겠습니까?`);

        // 확인이면 삭제 요청 보내기
        if (isConfirmed) {
            fetch(`/api/lol/groups/group-members`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    groupId: groupId,
                    groupMemberId: memberGameId
                })
            })
                .then((response) => {
                    if (!response.ok) {
                        throw new Error('멤버 삭제에 실패했습니다.');
                    }
                    // 삭제 성공 시 다시 그룹 정보를 가져오는 등의 작업 수행
                    fetchGroupDetail(groupId); // 그룹 정보 다시 가져오기
                })
                .catch((error) => {
                    console.error('멤버 삭제 오류:', error);
                    // 에러 처리 로직 추가
                });
        }
    };

    const handleAddMember = () => {
        // 새로운 멤버 추가 요청 보내기
        if (group.groupMemberPayloads.length >= 5) {
            // 그룹이 이미 최대 인원에 도달했을 때 사용자에게 알림을 표시합니다.
            alert('그룹이 가득 찼습니다.');
            return; // 추가 요청을 보내지 않고 함수를 종료합니다.
        }

        fetch(`/api/lol/groups/group-members`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                groupId: group.groupId,
                groupMember: memberName
            })
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('멤버 추가에 실패했습니다.');
                }
                // 추가 성공 시 다시 그룹 정보를 가져오는 등의 작업 수행
                fetchGroupDetail(); // 그룹 정보 다시 가져오기
                // 입력 필드 초기화
                setMemberName('');
            })
            .catch((error) => {
                console.error('멤버 추가 오류:', error);
                // 에러 처리 로직 추가
            });
    };


    const showBox = () => {
        setBoxVisible(true);
        setGroupExists(true); // 그룹 생성 창을 열 때 그룹이 존재하지 않음 메시지를 숨김
        // 폼 입력 상태 초기화
        setGroupName('');
        setGroupMembers([]);
    };

    const groupMemberAddBox = () => {
        setGroupNewMember(true);


    };

    const groupDetailBox = (groupId) => {
        fetchGroupDetail(groupId);
        console.log(group);
        setGroupDetail(true);
        setGroupExists(true); // 그룹 생성 창을 열 때 그룹이 존재하지 않음 메시지를 숨김

    };

    const hideBox = () => {
        setBoxVisible(false);
        setGroupDetail(false);
        setGroupNewMember(false);

        if (groups.length === 0) {
            setGroupExists(false); // 그룹 생성 취소 시 그룹이 없을 때 메시지를 보이도록 설정
        }
        // 폼 입력 상태 초기화
        setMemberName('');
        setGroupName('');
        setGroupMembers([]);
    };

    // 추가 멤버 이름 입력 시 상태 업데이트
    const handleMemberNameChange = (e) => {
        setMemberName(e.target.value);
    };

    // 그룹 이름 입력 시 상태 업데이트
    const handleGroupNameChange = (e) => {
        setGroupName(e.target.value);
    };

    // 게임 멤버들 입력 시 상태 업데이트
    const handleGameMembersChange = (e) => {
        setGroupMembers(e.target.value.split(',').map(member => member.trim()));
    };

    // 그룹 생성 요청 핸들러
    const handleSubmit = (e) => {
        e.preventDefault();

        // groupName과 gameMembers를 서버로 전송하여 그룹 생성 요청 보내는 로직을 구현할 수 있음

        // 예시: 그룹 생성 요청 보내기
        fetch('/api/lol/groups', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                groupName: groupName,
                groupMembers: groupMembers.map(gameName => ({gameName: gameName}))
            }),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('그룹 생성에 실패했습니다. 그룹당 인원은 최소 1명에서 5명까지 입니다.');
                }
                // 그룹 생성이 성공하면 다른 페이지로 리디렉션하는 등의 작업 수행 가능
                // 그룹 생성이 성공했을 때, 사용자에게 보여줄 메시지를 생성
                const successMessage = '그룹이 성공적으로 생성되었습니다.';
                alert(successMessage); // 사용자에게 메시지 표시
                // 그룹 생성이 성공했을 때, 그룹 보기 페이지로 이동
                setBoxVisible(false); // 그룹 등록 후 폼 숨기기
                fetchGroups();

            })
            .catch((error) => {
                console.error('그룹 생성 오류:', error);
                // 에러 처리 로직 추가
                setErrorMessage(error.message); // 오류 메시지 설정
            });
    };

    // 그룹 리스트를 가져오는 함수
    const fetchGroups = () => {
        fetch('/api/lol/groups')
            .then((response) => response.json())
            .then((data) => {
                setGroups(data);
                setGroupExists(data.length > 0); // 그룹 리스트가 비어있지 않으면 그룹이 존재함
            })
            .catch((error) => console.error('그룹 리스트 가져오기 오류:', error));
    };

    useEffect(() => {
        fetch('/api/lol/groups')
            .then((response) => response.json())
            .then((data) => {
                setGroups(data);
                setGroupExists(data.length > 0); // 그룹 리스트가 비어있지 않으면 그룹이 존재함
            });
    }, []);

    const handleDeleteGroup = (id) => {
        // 서버로 DELETE 요청을 보내는 부분
        const isConfirmed = window.confirm(`정말로 해당 그룹을 삭제하시겠습니까?`);

        if (isConfirmed) {
            fetch('/api/lol/groups', {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(id),
            })
                .then((response) => {
                    if (!response.ok) {
                        throw new Error('그룹 삭제에 실패했습니다.');
                    }
                    // 삭제가 성공하면 다시 그룹 리스트를 가져오는 등의 작업을 수행할 수 있습니다.
                    const successMessage = '그룹을 성공적으로 삭제했습니다.';
                    alert(successMessage); // 사용자에게 메시지 표시
                    // 예: 삭제 후 그룹 리스트를 다시 가져오는 함수 호출
                    fetchGroups();
                })
                .catch((error) => {
                    console.error('그룹 삭제 오류:', error);
                    // 에러 처리 로직 추가
                });
        }
    };

    const handleClick = () => {
        history("/");
    };

    useEffect(() => {
        if (errorMessage) {
            const timer = setTimeout(() => {
                setErrorMessage('');
            }, 5000); // 5초 후에 errorMessage를 초기화합니다.

            return () => clearTimeout(timer); // 컴포넌트가 unmount되거나 errorMessage가 변경될 때 타이머를 해제합니다.
        }
    }, [errorMessage]);

    return (
        <div className="group-list-home">

            {errorMessage && (
                <div className="error-alert">
                    {errorMessage}
                </div>
            )}


            <div className="home-redirect-icon">
                <a href="/">
                    <img
                        src={"https://image.shutterstock.com/image-vector/letters-duo-joint-logo-icon-250nw-1113311357.jpg"}
                        alt="home_icon"
                        style={{
                            width: '100px',
                            height: '65px',
                            marginLeft: '20px',
                            borderRadius: '25%',
                            marginTop: '10px',
                            cursor: 'pointer' // 마우스 커서를 포인터로 변경하여 클릭 가능한 상태를 나타냅니다.
                        }}
                    />
                </a>
            </div>
            <button className="group-menu-button" onClick={showBox}>그룹 등록</button>
            <button className="group-menu-button" style={{marginLeft: '160px'}} onClick={handleClick}>뒤로가기</button>

            {boxVisible && (
                <div className="group-center-box">
                    <form onSubmit={handleSubmit}>
                        <div className="input-container">
                            <label>그룹 이름: </label>
                            <input type="text" placeholder="그룹이름을 입력해주세요." value={groupName}
                                   onChange={handleGroupNameChange}
                                   required/>
                        </div>
                        <div className="input-summoner">
                            <label>소환사 닉네임: </label>
                            <textarea placeholder="등록할 닉네임을 입력해주세요.    (쉼표로 구분해 주세요~)" rows="4" cols="20"
                                      value={groupMembers.join(', ')}
                                      onChange={handleGameMembersChange}
                                      required></textarea>
                            <label> 태그를 함께 입력해주세요.) #KR1</label>
                        </div>
                        <div className="group-box-buttons">
                            <button type="submit">등록</button>
                            <button type="button" onClick={hideBox}>취소</button>
                        </div>
                    </form>
                </div>
            )}

            <div className="group-list-container">
                {groupExists ? (
                    <ul className="group-list">
                        {groups.map((group, index) => (
                            <li key={index} onClick={() => groupDetailBox(group.id)} className="groupList-item">
                                <div>{group.groupName}</div>
                                <button onClick={(e) => {
                                    e.stopPropagation(); // 부모 요소로의 이벤트 전파(stopPropagation) 방지
                                    handleDeleteGroup(group.id);
                                }} className="delete-button">그룹 삭제
                                </button>

                                <button onClick={(e) => {
                                    e.stopPropagation();
                                    groupMemberAddBox();
                                }} className="groupMember-add-Button">멤버 추가
                                </button>
                            </li>
                        ))}
                    </ul>
                ) : (
                    <div className="groupList-message">
                        <div>그룹이 존재하지 않습니다.</div>
                    </div>
                )}
            </div>

            {groupNewMember && (
                <div className="groupMemberAdd-box">
                    <form onSubmit={handleAddMember}>
                        <div className="input-container">
                            <label>멤버 이름: </label>
                            <input type="text" placeholder="등록할 닉네임을 입력해주세요." value={memberName}
                                   onChange={handleMemberNameChange}
                                   required/>
                        </div>
                        <label> 태그를 함께 입력해주세요.) #KR1</label>

                        <div className="groupMemberAdd-Button">
                            <button type="submit">추가</button>
                            <button type="button" onClick={hideBox}>취소</button>
                        </div>
                    </form>
                </div>
            )}

            {groupDetail && (
                <div className="groupDetail-box">
                    <div className="groupNameDetail">{group.groupName}</div>
                    {group.groupMemberPayloads && Array.from(group.groupMemberPayloads).map((groupMemberPayload, index) => (
                        <li key={index} className="gameMemberName">
                            <div style={{fontSize: '20px'}}>{groupMemberPayload.gameName}</div>
                            <button onClick={() => handleDeleteMember(group.groupId, groupMemberPayload.id)}
                                    className="groupMember-delete-button">멤버 삭제
                            </button>
                        </li>
                    ))}
                    <div className="groupFind-buttons">
                        <Link className="groupFindButton" to={`/group/groupMembers/${group.groupId}`}>그룹 조회</Link>
                        <button type="button" onClick={hideBox}>취소</button>
                    </div>
                </div>
            )}
        </div>
    );
};

export default GroupList;