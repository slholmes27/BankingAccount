/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsolutions;


 /*
 * @author Shaquina
 */
public class ThreadSolutions {
    private static Object thePlanner;

    /**
     * //@param args the command line arguments
     */// CHANGED for THREAD IMPLEMENTATION”
    
    public static class myRunnable implements Runnable {
        
        @Override
        public void run(){
            System.out.println("import java.util.Vector;\n" +
"import java.util.HashMap;\n" +
"\n" +
"import mvc.ResponderView;\n" +
"\n" +
"import data.AreaDb;\n" +
"import data.AreaInformation;\n" +
"import data.ResponderInformation;\n" +
"import data.ResponderDb;\n" +
"\n" +
"\n" +
"/*\n" +
" * A singleton planner instantiating data base and standard plan elements\n" +
" * primary purpose is to map views to models and establish correct observation\n" +
" * */\n" +
"\n" +
"public class Planner { \n" +
"\n" +
"	public static Planner thePlanner = null;\n" +
"	public Vector<Plan> plans = null;\n" +
"	\n" +
"	private final AreaDb areaDb = AreaDb.getDb();\n" +
"	final private ResponderDb responderDb = ResponderDb.getDb();\n" +
"	\n" +
"	\n" +
"	public Vector<ResponderInformation> defaultResponders = null;\n" +
"	public DefaultPlan theDefaultPlan = null;\n" +
"	Vector<ResponderView> views = new Vector<ResponderView>();\n" +
"\n" +
"	HashMap<ResponderView, Plan> planMap = new HashMap<ResponderView, Plan>();\n" +
"\n" +
"\n" +
"	public Planner() {\n" +
"		plans = new Vector<Plan>();\n" +
"		defaultResponders = new Vector<ResponderInformation>();\n" +
"		ResponderInformation r = responderDb.get(\"EHS\"); // EHS should always be there!\n" +
"		defaultResponders.add(r);\n" +
"		r = responderDb.get(\"Public Safety\"); // Public Safety should always be there!\n" +
"		defaultResponders.add(r);\n" +
"		theDefaultPlan = new DefaultPlan();\n" +
"	}\n" +
"\n" +
"	// return the singleton planner - creating a planner if none exists\n" +
"	public static Planner getThePlanner() {\n" +
"		if (thePlanner == null)\n" +
"			thePlanner = new Planner();\n" +
"		return thePlanner;\n" +
"	}\n" +
"\n" +
"	// return a plan from information given for interview\n" +
"	// used by unit tests\n" +
"	public Plan getPlan(String[] inputs, SpillCase spill, int sz) {\n" +
"		Interview interview = new Interview(inputs, spill, sz);\n" +
"		return getPlan(interview);\n" +
"	}\n" +
"\n" +
"	// returns a plan determined by contents of the interview\n" +
"	private Plan getPlan(Interview interview) {\n" +
"		Plan p = Plan.buildActionPlan(this, interview);\n" +
"		plans.add(p);\n" +
"		return p;\n" +
"	}\n" +
"\n" +
"	// record a responder view in the planner\n" +
"	// TODO: complete view <--> plan map\n" +
"	public void addView(ResponderView v) {\n" +
"		System.out.println(\"Planner: adding view\" + v);\n" +
"		views.add(v);\n" +
"	}\n" +
"\n" +
"	// TODO: change to AdminView\n" +
"	public void registerView(ResponderView view) {\n" +
"		this.views.add(view);	\n" +
"	}\n" +
"\n" +
"	// find a responder in the database \n" +
"	// exceptions for name not found or name not qualified\n" +
"	// TODO: eventually improve name match\n" +
"	ResponderInformation getResponder(String contact, SpillCase material){\n" +
"		ResponderInformation r = responderDb.get(contact);\n" +
"		// TODO: add real check for qualifications\n" +
"		return r;\n" +
"	}\n" +
"\n" +
"	// return area information information\n" +
"	public AreaInformation findArea(String rm, String bldg) {\n" +
"		//AreaInfo info = database.getArea(rm, bldg);\n" +
"		int bldgNo = 0;\n" +
"		int roomNo = 0;\n" +
"		try {\n" +
"			bldgNo = Integer.parseInt(bldg);\n" +
"		} catch (NumberFormatException e) {\n" +
"			bldgNo = 0;\n" +
"		}\n" +
"		try {\n" +
"			roomNo = Integer.parseInt(rm);\n" +
"		} catch (NumberFormatException e) {\n" +
"			roomNo = 0;\n" +
"		}\n" +
"		// just return EHS if building, room unrecognized!\n" +
"		AreaInformation info = areaDb.find(bldgNo, roomNo);\n" +
"		return info;\n" +
"	}\n" +
"\n" +
"	// EHS information used as a default\n" +
"	public AreaInformation getEhsAreaInfo() {\n" +
"		return areaDb.ehsAreaInfo;\n" +
"	}\n" +
"\n" +
"	public void consumeSpillKit(String building, String room) {\n" +
"		/// database.consumeSpillKit(building,room);\n" +
"		int rm = Integer.parseInt(room);\n" +
"		int bldg = Integer.parseInt(building);\n" +
"		areaDb.consumeSpillKit(bldg, rm);\n" +
"	}\n" +
"	\n" +
"}     ");
        }
    }
    
    public static void main(String[] args) {
        Thread myThread = new Thread(new myRunnable());
        
    myThread.start();
    }
}




    
