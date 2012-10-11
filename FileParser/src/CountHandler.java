public class CountHandler implements ContentHandler {
	int compL =0,cmpC=0;

	public int getCompL() {
		return compL;
	}
	public int getCmpC() {
		return cmpC;
	}

	@Override
	public void defaultLine(String content) {
			compL++;
	}
	@Override
	public void commentLine(String comment) {
			cmpC++;
			
	}
}
