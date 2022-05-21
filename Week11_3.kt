private lateinit var mMap: GoogleMap
private lateinit var fusedLocationClient: FusedLocationProviderClient
private lateinit var locationCallback: LocationCallback

override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val permissions = arrayOf(
        android.Manifest.permission.ACCESS_COARSE_LOCATION
        android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    requirePermissions(permissions,999)
}

fun startProcess(){
    val mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
    mapFragment.getMapAsync(this)
}

fun requirePermissions(permissions: Array<String>, requestCode: Int){
    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
        permissionGranted(requestCode)
    } else {
        val isAllPermissionsGranted = permissions.all {
            checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
        }
        if(isAllPermissionsGranted){
            permissionGranted(requestCode)
        } else{
            ActivityCompat.requestPermissions(this,permissions,requestCode)
        }
    }
}