import java.util.ArrayList;
import java.util.Collections;

public class Location {
// this class is a location with (x, y) value
	public int first;// x
	public int second;// y

	public Location() {
	}

	public void copy(Location l) {
		this.first = l.first;
		this.second = l.second;
	}

	public static int l1distance_between(Location a, Location b) {// find distance between two point along lattice route
		return Math.abs(a.first - b.first) + Math.abs(a.second - b.second);
	}

	public static int getl1distance(ArrayList<Location> list, Location median) {
		int distance = 0;
		for (int i = 0; i < list.size(); i++) {// adds up all distances in list of locations
			distance += Location.l1distance_between(median, list.get(i));
		}
		return distance;
	}

	public static double l2distance_between(Location a, Location b) {// find straight line distance between two points
		return Math.sqrt(Math.pow((a.first - b.first), 2) + (Math.pow((a.second - b.second), 2)));
	}

	public static double getl2distance(ArrayList<Location> list, Location median) {
		double distance = 0;
		for (int i = 0; i < list.size(); i++) {// adds up all straight line distances
			distance += Location.l2distance_between(median, list.get(i));
		}
		return distance;

	}

	public static Location get_median(ArrayList<Location> list) {
		Location median = new Location();
		ArrayList<Integer> xarray = new ArrayList<>();// finds the median x and y coordinates in a list of locations
		ArrayList<Integer> yarray = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {

			xarray.add(list.get(i).first);
			yarray.add(list.get(i).second);
		}
		Collections.sort(xarray);// sorting the x values
		Collections.sort(yarray);
		if(xarray.size()%2 == 0) {
			median.first = (xarray.get(xarray.size() / 2) + xarray.get((xarray.size() / 2) - 1))/2;
		}else {
		median.first = xarray.get(xarray.size() / 2);// the median is the middle number in the sorted list
		}
		if(yarray.size()%2 == 0) {
			median.second = (yarray.get(yarray.size() / 2) + yarray.get((yarray.size() / 2) - 1))/2;
		}else {		
		median.second = yarray.get(yarray.size() / 2);
		}
		return median;
	}
	
	
	public static void l1(ArrayList<Location> list) {// takes a list and finds the point with shortest distance to all
														// points overall
		Location median = Location.get_median(list);// along the lattice route
		System.out.print(median);
		System.out.println(" " + Location.getl1distance(list, median));// this function prints out the results of l1
	}

	public static void l2(ArrayList<Location> list) {// O(n^2) takes a list and finds the point with shortest distance
														// to all
														// points overall
		Location start_point = Location.get_median(list); // gets median for a starting point to crawl from

		// first initialize all crawl directions
		Location hunt_left = new Location(); // crawls in eight directions searching for lower overall distance
		Location hunt_right = new Location();
		Location hunt_up = new Location();
		Location hunt_down = new Location();
		Location hunt_upleft = new Location();
		Location hunt_upright = new Location();
		Location hunt_downleft = new Location();
		Location hunt_downright = new Location();

		boolean reduced = true;
		// while a reduction in distances is detected by crawlers continue searching
		while (reduced) {// O(n)
			reduced = false;
			// get new start point
			hunt_left.copy(start_point);
			hunt_right.copy(start_point);
			hunt_up.copy(start_point);
			hunt_down.copy(start_point);
			hunt_upleft.copy(start_point);
			hunt_upright.copy(start_point);
			hunt_downleft.copy(start_point);
			hunt_downright.copy(start_point);
			// initialize crawl positions
			hunt_left.first--;
			hunt_right.first++;
			hunt_up.second++;
			hunt_down.second--;
			hunt_upleft.first++;
			hunt_upleft.second++;
			hunt_upright.first++;
			hunt_upright.second++;
			hunt_downleft.first--;
			hunt_downleft.second--;
			hunt_downright.first++;
			hunt_downright.second--;

			if (Location.getl2distance(list, start_point) > Location.getl2distance(list, hunt_left)) {// O(n) on every
																										// if
				start_point.first = hunt_left.first;
				start_point.second = hunt_left.second;
				reduced = true;
			}
			if (Location.getl2distance(list, start_point) > Location.getl2distance(list, hunt_right)) {
				start_point.first = hunt_right.first;
				start_point.second = hunt_right.second;
				reduced = true;
			}
			if (Location.getl2distance(list, start_point) > Location.getl2distance(list, hunt_up)) {
				start_point.first = hunt_up.first;
				start_point.second = hunt_up.second;
				reduced = true;
			}
			if (Location.getl2distance(list, start_point) > Location.getl2distance(list, hunt_down)) {
				start_point.first = hunt_down.first;
				start_point.second = hunt_down.second;
				reduced = true;
			}
			if (Location.getl2distance(list, start_point) > Location.getl2distance(list, hunt_upleft)) {
				start_point.first = hunt_upleft.first;
				start_point.second = hunt_upleft.second;
				reduced = true;
			}
			if (Location.getl2distance(list, start_point) > Location.getl2distance(list, hunt_upright)) {
				start_point.first = hunt_upright.first;
				start_point.second = hunt_upright.second;
				reduced = true;
			}
			if (Location.getl2distance(list, start_point) > Location.getl2distance(list, hunt_downleft)) {
				start_point.first = hunt_downleft.first;
				start_point.second = hunt_downleft.second;
				reduced = true;
			}
			if (Location.getl2distance(list, start_point) > Location.getl2distance(list, hunt_downright)) {
				start_point.first = hunt_downright.first;
				start_point.second = hunt_downright.second;
				reduced = true;
			} // the loop exits when no more reduction is possible

		}

		System.out.print(start_point);
		System.out.println(" " + Location.getl2distance(list, start_point));// this function print out the results of l2
	}

	@Override
	public String toString() {// override to print a location
		return "(" + first + "," + second + ")";
	}
}
