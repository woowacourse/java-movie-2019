package view;
public enum ErrMsg {
	WrongMovieId("존재하지 않는 영화입니다.",0),
	WrongMovieTime("존재하지 않는 시간표 입니다.",1);
	
	String errMsg;
	int index;
	private ErrMsg(String errMsg, int index){
		this.errMsg = errMsg; 
		this.index = index;
	}
	
	String getMsg() {
		return errMsg;
	}
	
	int getIndex() {
		return index;
	}
}
