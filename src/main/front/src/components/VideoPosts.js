import React, {useState, useEffect} from 'react';
import './VideoPosts.css';
import {Link, useNavigate} from 'react-router-dom';

function VideoPosts() {
    const [showPopup, setShowPopup] = useState(false);
    const [postData, setPostData] = useState({
        videoUrl: 'https://',
        title: '',
        nickname: '',
        password: ''
    });
    const [emptyFields, setEmptyFields] = useState([]);
    const [posts, setPosts] = useState([]);
    const [currentPage, setCurrentPage] = useState(0); // 현재 페이지 상태 추가
    /** 게시글 삭제관련 */
    const [postIdToDelete, setPostIdToDelete] = useState(null); // 삭제할 게시물의 아이디 상태 추가
    const [showDeletePopup, setShowDeletePopup] = useState(false);
    const [deletePassword, setDeletePassword] = useState('');
    /** 댓글 관련*/
    const [comments, setComments] = useState([]);
    const [showCommentPopup, setShowCommentPopup] = useState(false); // 댓글 팝업창 상태 추가
    const [showCommentListPopup, setShowCommentListPopup] = useState(false); // 댓글 목록 팝업 상태 추가
    const [selectedPostId, setSelectedPostId] = useState(null); // 댓글 등록할 게시물의 아이디 상태 추가
    /** 댓글 삭제 */
    const [deleteCommentPassword, setDeleteCommentPassword] = useState('');
    const [deleteCommentId, setDeleteCommentId] = useState(null);

    const navigate = useNavigate();

    useEffect(() => {
        fetchPosts();
    }, [currentPage]);

    const fetchPosts = async () => {
        try {
            const response = await fetch(`/api/lol/posts?page=${currentPage}`);
            if (!response.ok) {
                throw new Error('게시글을 불러오는 중 오류가 발생했습니다.');
            }
            const data = await response.json();
            setPosts(data.postPayloads.content || []); // 게시물이 없을 경우 빈 배열로 설정
            console.log(data.postPayloads.content)
        } catch (error) {
            console.error('게시글 불러오기 오류:', error);
        }
    };

    const handleButtonClick = () => {
        setShowPopup(true);
    };

    const handleClosePopup = () => {
        setShowPopup(false);
    };

    const handleInputChange = (event) => {
        const {name, value} = event.target;
        setPostData({
            ...postData,
            [name]: value
        });
    };

    const handleCreatePost = () => {
        const emptyFieldsArray = Object.keys(postData).filter(key => !postData[key]);
        setEmptyFields(emptyFieldsArray);
        if (emptyFieldsArray.length === 0) {
            createPost();
        }
    };

    const createPost = async () => {
        try {
            const response = await fetch('/api/lol/posts', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(postData)
            });
            if (!response.ok) {
                throw new Error('게시글을 생성하는 중 오류가 발생했습니다.');
            }
            handleClosePopup();
            fetchPosts(); // 새로운 게시글이 추가되면 전체 게시글을 다시 불러옴
        } catch (error) {
            console.error('게시글 생성 오류:', error);
        }
    };
    const formatDate = (dateString) => {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        const hour = String(date.getHours()).padStart(2, '0');
        const minute = String(date.getMinutes()).padStart(2, '0');
        const second = String(date.getSeconds()).padStart(2, '0');
        return `${year}-${month}-${day} ${hour}:${minute}:${second}`;
    };

    const emptyFieldMessage = emptyFields.length > 0 ? 'URL, 제목, 작성자, 암호를 모두 입력해 주세요.' : '';

    const handlePrevPage = () => {
        if (currentPage === 0) {
            alert('첫 페이지 입니다.');
        } else {
            setCurrentPage(currentPage - 1);
        }
    };

    const handleNextPage = () => {
        fetch(`/api/lol/posts?page=${currentPage + 1}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('데이터가 없습니다.');
                }
                return response.json(); // 다음 페이지의 데이터를 받아옵니다.
            })
            .then(data => {
                if (data.length === 0) {
                    alert('마지막 페이지 입니다.');
                } else {
                    setCurrentPage(currentPage + 1);
                }
            })
            .catch(error => {
                alert(error.message);
            });
    };
    const handleLikeClick = async (postId) => {
        try {
            const response = await fetch(`/api/lol/posts/${postId}/likes`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            if (!response.ok) {
                throw new Error('좋아요 추가 중 오류가 발생했습니다.');
            }
            fetchPosts();
        } catch (error) {
            console.error('좋아요 추가 오류:', error);
        }
    };
    const handleUnlikeClick = async (postId) => {
        try {
            const response = await fetch(`/api/lol/posts/${postId}/unlikes`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            if (!response.ok) {
                throw new Error('싫어요 추가 중 오류가 발생했습니다.');
            }
            fetchPosts();
        } catch (error) {
            console.error('싫어요 추가 오류:', error);
        }
    };
    /** 게시글 삭제관련 */
    const handleDeleteClick = (postId) => {
        setPostIdToDelete(postId);
        setShowDeletePopup(true);
    };
    /** 게시글 삭제관련 */
    const handleDeleteConfirm = async () => {
        try {
            const response = await fetch(`/api/lol/posts/${postIdToDelete}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({password: deletePassword}) // 패스워드를 함께 전송
            });
            if (!response.ok) {
                throw new Error('게시글 삭제 중 오류가 발생했습니다.');
            }
            setShowDeletePopup(false);
            fetchPosts();
        } catch (error) {
            console.error('게시글 삭제 오류:', error);
        }
    };
    // 게시글 삭제관련
    const handleDeleteCancel = () => {
        setShowDeletePopup(false); // 팝업 닫기
        setDeletePassword(''); // 패스워드 입력 초기화
    };

    /** 이미지 & 제목 클릭 시 링크 이동*/
    const handlePostClick = (videoUrl) => {
        window.location.href = videoUrl;
    };

    /** 댓글 전체 조회*/
    const handleCommentClick = async (postId) => {
        try {
            const response = await fetch(`/api/lol/posts/${postId}/comments`);
            if (!response.ok) {
                throw new Error('댓글을 불러오는 중 오류가 발생했습니다.');
            }
            const data = await response.json();
            const fetchedComments = data.commentPayloads || []; // 댓글 데이터가 commentPayloads에 들어있다고 가정
            setComments(fetchedComments);
            setShowCommentListPopup(true); // 댓글 목록 팝업 창 열기

        } catch (error) {
            console.error('댓글 불러오기 오류:', error);
        }
    };
    const fetchComments = async (postId) => {
        try {
            const response = await fetch(`/api/lol/posts/${postId}/comments`);
            if (!response.ok) {
                throw new Error('댓글을 불러오는 중 오류가 발생했습니다.');
            }
            const data = await response.json();
            const fetchedComments = data.commentPayloads || []; // 댓글 데이터가 commentPayloads에 들어있다고 가정
            setComments(fetchedComments);
        } catch (error) {
            console.error('댓글 불러오기 오류:', error);
        }
    };

    /** 댓글 삭제 */
    const handleDeleteCommentClick = (commentId, postId) => {
        setDeleteCommentId(commentId);
        setPostIdToDelete(postId); // 댓글이 속한 게시물의 아이디 설정

    };
    // 댓글 삭제 팝업을 닫습니다.
    const handleDeleteCommentCancel = () => {
        setDeleteCommentId(null);
    };

    const handleDeleteCommentConfirm = async () => {
        try {
            if (!postIdToDelete) {
                throw new Error('게시물 아이디가 없습니다.');
            }
            const response = await fetch(`/api/lol/posts/${postIdToDelete}/comments/${deleteCommentId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({password: deleteCommentPassword}) // 패스워드를 함께 전송
            });
            if (!response.ok) {
                throw new Error('댓글 삭제 중 오류가 발생했습니다.');
            }
            console.log('댓글이 성공적으로 삭제되었습니다.');
            fetchComments(postIdToDelete);
            setDeleteCommentId(null);
        } catch (error) {
            console.error('댓글 삭제 오류:', error);
        }
    };

    /** 댓글 등록*/
    const handleCommentButtonClick = (postId) => {
        setSelectedPostId(postId); // 클릭된 게시물의 아이디 저장
        setPostData(prevData => ({
            ...prevData,
            comments: {
                ...prevData.comments,
                postId: postId // 선택된 게시물의 postId 설정
            }
        }));
        setShowCommentPopup(true); // 댓글 등록 팝업 열기
    };

    const handleCommentCancel = () => {
        setShowCommentPopup(false);
    };
    const handleCommentInputChange = (event) => {
        const {name, value} = event.target;
        setComments({
            ...comments,
            [name]: value
        });
    };

    const handleCommentSubmitPopup = async () => {
        const {nickname, password, content} = comments;
        const postId = selectedPostId;
        try {
            const response = await fetch(`/api/lol/posts/${postId}/comments`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({nickname, password, content})
            });
            if (!response.ok) {
                throw new Error('댓글을 등록하는 중 오류가 발생했습니다.');
            }
            fetchComments(postId); // 댓글이 등록되면 해당 게시물의 댓글을 다시 불러옴
            setShowCommentPopup(false); // 댓글 팝업 닫기
        } catch (error) {
            console.error('댓글 등록 오류:', error);
        }
    };

    return (
        <div className="video-post-page">
            <Link to="/" className="video-post-redirect-icon">
                <img
                    src="https://image.shutterstock.com/image-vector/letters-duo-joint-logo-icon-250nw-1113311357.jpg"
                    alt="home_icon"
                    style={{
                        marginLeft: "5%",
                        marginTop: "3.5%",
                        width: "8%",
                        height: "12%",
                        position: "absolute",
                    }}
                />
            </Link>
            <h1 className="video-post-title">영상 게시판</h1>
            <div className="post-menu-btn">
                <button className="pre-btn" onClick={handlePrevPage}>이전</button>
                <button className="next-btn" onClick={handleNextPage}>다음</button>
                <button className="add-post-button" onClick={handleButtonClick}>영상 게시글 등록</button>
            </div>
            {showPopup && (
                <div className="popup">
                    <div className="popup-content">
                        <label htmlFor="url">URL (필수 입력)</label>
                        <input type="text" id="url" name="videoUrl" value={postData.videoUrl}
                               onChange={handleInputChange}
                               required defaultValue="https://"/>
                        <label htmlFor="title">제목 (4자 이상 필수 입력)</label>
                        <input type="text" id="title" name="title" value={postData.title}
                               onChange={handleInputChange}
                               required/>
                        <label htmlFor="nickname">작성자 (필수 입력)</label>
                        <input type="text" id="nickname" name="nickname" value={postData.nickname}
                               onChange={handleInputChange} required/>
                        <label htmlFor="password">암호 (3자 이상 필수 입력)</label>
                        <input type="password" id="password" name="password" value={postData.password}
                               onChange={handleInputChange} required/>
                        <p style={{color: 'red'}}>{emptyFieldMessage}</p>
                        <div className="popup-button">
                            <button className="popup-btn" onClick={handleCreatePost}>등록</button>
                            <button className="popup-btn" onClick={handleClosePopup}>취소</button>
                        </div>
                    </div>
                </div>
            )}
            <div className="post-container">
                {posts.length === 0 ? (
                    <div className="empty-message-container">
                        <h1 className="empty-message">게시물이 존재하지 않습니다.</h1>
                    </div>
                ) : (
                    <div className="post-list">
                        {posts.map((post, index) => (
                            <div key={index} className="post-item">
                                <div className="like-unlike-container">
                                    <button className="like-btn" onClick={() => handleLikeClick(post.id)}>😁 좋아요
                                    </button>
                                    <button className="unlike-btn" onClick={() => handleUnlikeClick(post.id)}>😭 싫어요
                                    </button>
                                </div>
                                <div className="post-item-container">
                                    <img
                                        src={post.thumbnailImageUrl}
                                        alt={"thumbnailImage"}
                                        className="thumbnail-img"
                                        onClick={() => handlePostClick(post.videoUrl)}/>

                                    <div className="post-item-text">
                                        <h1 onClick={() => handlePostClick(post.videoUrl)}>{post.title}</h1>
                                        <div className="post-info-item-1">
                                            <p>좋아요 [ {post.likeCount} ]</p>
                                            <p>작성자: {post.nickname}</p>
                                        </div>
                                        <div className="post-info-item-2">
                                            <p className="comments-btn"
                                               onClick={() => handleCommentClick(post.id)}>댓글
                                                [ {post.commentsCount} ]</p>
                                            <p>등록일: {formatDate(post.createdAt)}</p>
                                        </div>
                                        <button className="comment-create-btn"
                                                onClick={() => handleCommentButtonClick(post.id)}>댓글 등록
                                        </button>
                                        {/** 댓글 등록 팝업창 */}
                                        {showCommentPopup && selectedPostId === post.id && (
                                            <div className="comment-create-popup">
                                                <div className="comment-create-popup-content">
                                                    <label htmlFor="nickname">작성자 (필수 입력)</label>
                                                    <input type="text" id="nickname" name="nickname"
                                                           value={comments.nickname}
                                                           onChange={handleCommentInputChange}/>
                                                    <label htmlFor="password">패스워드 (필수 입력)</label>
                                                    <input type="password" id="password" name="password"
                                                           value={comments.password}
                                                           onChange={handleCommentInputChange}/>
                                                    <label htmlFor="content">내용 (필수 입력)</label>
                                                    <textarea id="content" name="content"
                                                              value={comments.content}
                                                              onChange={handleCommentInputChange}/>
                                                    <button className="comment-submit-btn"
                                                            onClick={handleCommentSubmitPopup}>등록
                                                    </button>
                                                    <button className="comment-cancel-btn"
                                                            onClick={handleCommentCancel}>취소
                                                    </button>
                                                </div>
                                            </div>
                                        )}
                                        <button className="post-delete-btn"
                                                onClick={() => handleDeleteClick(post.id)}>삭제
                                        </button>
                                        {showDeletePopup && postIdToDelete === post.id && (
                                            <div className="delete-popup">
                                                <div className="delete-popup-content">
                                                    <label htmlFor="deletePassword">암호 (3자 이상 필수 입력) : </label>
                                                    <input
                                                        type="password"
                                                        id="deletePassword"
                                                        value={deletePassword}
                                                        onChange={(e) => setDeletePassword(e.target.value)} // deletePassword 상태 업데이트
                                                    />
                                                    <div className="delete-popup-buttons">
                                                        <button className="delete-confirm-btn"
                                                                onClick={handleDeleteConfirm}>확인
                                                        </button>
                                                        <button className="delete-cancel-btn"
                                                                onClick={handleDeleteCancel}>취소
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        )}
                                    </div>
                                </div>
                            </div>
                        ))}
                        {/* 댓글 목록 팝업창 */}
                        {showCommentListPopup && (
                            <div className="comment-popup">
                                <div className="comment-popup-content">
                                    {/* 댓글 목록 표시 */}
                                    {comments.length === 0 ? (
                                        <p>존재하는 댓글이 없습니다.</p>
                                    ) : (
                                        <ul>
                                            {comments.map((comment, index) => (
                                                <li key={index} className="comment-item">
                                                    <p>- {comment.content}</p>
                                                    <p className="comment-info">작성자: {comment.nickname}</p>
                                                    <p className="comment-info">등록일: {formatDate(comment.createdAt)}</p>
                                                    {/*<button className="comment-item-delete-btn"*/}
                                                    {/*        onClick={() => handleDeleteComment(comment.postId, comment.id)}>삭제*/}
                                                    <button className="comment-item-delete-btn"
                                                            onClick={() => handleDeleteCommentClick(comment.id, comment.postId)}>댓글
                                                        삭제
                                                    </button>
                                                    {/*</button>*/}
                                                </li>
                                            ))}
                                        </ul>
                                    )}
                                    {/* 댓글 삭제 팝업 */}
                                    {deleteCommentId && (
                                        <div className="delete-comment-popup">
                                            <div className="delete-comment-popup-content">
                                                <label htmlFor="deleteCommentPassword">댓글 삭제를 위해 패스워드를 입력하세요:</label>
                                                <input
                                                    type="password"
                                                    id="deleteCommentPassword"
                                                    value={deleteCommentPassword}
                                                    onChange={(e) => setDeleteCommentPassword(e.target.value)} // deletePassword 상태 업데이트
                                                />
                                                <div className="delete-comment-popup-buttons">
                                                    <button className="delete-comment-confirm-btn"
                                                            onClick={handleDeleteCommentConfirm}>확인
                                                    </button>
                                                    <button className="delete-comment-cancel-btn"
                                                            onClick={handleDeleteCommentCancel}>취소
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    )}
                                    <button className="comment-item-close-btn"
                                            onClick={() => setShowCommentListPopup(false)}>닫기
                                    </button>
                                </div>
                            </div>
                        )}
                    </div>
                )}
            </div>
        </div>
    );
}

export default VideoPosts;
