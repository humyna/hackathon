package info.zoio.hackathon.wealthradius.core.mappers.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Long userId;

    /**
     * 手机号
     */
    @Column(name = "mobile_no")
    private String mobileNo;

    private String password;

    private String salt;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "face_sign_info")
    private String faceSignInfo;

    @Column(name = "face_recognition_date")
    private Date faceRecognitionDate;

    @Column(name = "invite_code")
    private Integer inviteCode;

    private String comments;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取手机号
     *
     * @return mobile_no - 手机号
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置手机号
     *
     * @param mobileNo 手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return face_sign_info
     */
    public String getFaceSignInfo() {
        return faceSignInfo;
    }

    /**
     * @param faceSignInfo
     */
    public void setFaceSignInfo(String faceSignInfo) {
        this.faceSignInfo = faceSignInfo == null ? null : faceSignInfo.trim();
    }

    /**
     * @return face_recognition_date
     */
    public Date getFaceRecognitionDate() {
        return faceRecognitionDate;
    }

    /**
     * @param faceRecognitionDate
     */
    public void setFaceRecognitionDate(Date faceRecognitionDate) {
        this.faceRecognitionDate = faceRecognitionDate;
    }

    /**
     * @return invite_code
     */
    public Integer getInviteCode() {
        return inviteCode;
    }

    /**
     * @param inviteCode
     */
    public void setInviteCode(Integer inviteCode) {
        this.inviteCode = inviteCode;
    }

    /**
     * @return comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", salt=" + salt + ", nickName=" + nickName + ", createDate=" + createDate
				+ ", faceSignInfo=" + faceSignInfo + ", faceRecognitionDate=" + faceRecognitionDate
				+ ", inviteCode=" + inviteCode + ", comments=" + comments + "]";
	}
    
    
}