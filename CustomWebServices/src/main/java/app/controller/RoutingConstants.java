/**
 * 
 */
package app.controller;

/**
 * @author José Valenzuela Soto.
 *
 */
public interface RoutingConstants {

	public final String TEST_CTRL_PATH="/test/aulas";
	public final String TEST_CTRL_DEFAULT = "/default";
	public final String PAR0101_NAME="idaula";
	public final boolean PAR0101_REQ=true;
	public final String PAR0101_DEF="";
	public final String PAR0102_NAME="tipres";
	public final boolean PAR0102_REQ=true;
	public final String PAR0102_DEF="1";
	public final String TEST_CTRL_CUSTOM = "/custom";
	public final String PAR0201_NAME="idaula";
	public final boolean PAR0202_REQ=true;
	public final String PAR0202_DEF="";
	
	public final String FORMAT_TO_PRODUCE="application/json";
	public final String CORS = "*";
	
}
