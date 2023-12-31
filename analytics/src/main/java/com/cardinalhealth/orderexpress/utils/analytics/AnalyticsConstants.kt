package com.cardinalhealth.orderexpress.utils.analytics


class AnalyticsConstants {

    companion object {
        //Flurry
        const val MAPPING_FILE = "analytics_keys.json"
        const val EVENT_USER_LOGIN = "UserLogin"
        const val EVENT_FEEDBACK = "Feedback"
        const val EVENT_TAB_BAR = "TabBar"
        const val EVENT_AUDIT_SUBMIT = "AuditSubmit"
        const val EVENT_SUBMIT_ALL_ORDERS = "SubmitAllOrders"
        const val EVENT_CART_UPLOAD_ALL = "CartUploadAll"
        const val EVENT_PRODUCT_LOOKUP = "ProductLookup"
        const val EVENT_ADD_ALTERNATE_ORDER = "AddAlternateToOrder"
        const val EVENT_VIEW_ALTERNATE = "ViewAlternate"
        const val EVENT_SUBMIT_SINGLE_ORDER = "SubmitSingleOrder"
        const val EVENT_CART_UPLOAD_ORDER = "CartUploadOrder"
        const val EVENT_ADD_TO_ORDER = "AddToOrder"
        const val EVENT_INVENTORY_LANDING = "InventoryLanding"
        const val EVENT_LOCATION_COST_TYPE = "LocationCostType"
        const val EVENT_RECEIVING_SERVICE_REQUEST = "ReceivingSubmitServiceRequest"
        const val EVENT_INVENTORY_UPLOAD_LOCATION = "InventoryUploadLocation"
        const val EVENT_RECEIVING_UPLOAD_TOTE = "ReceivingUploadTote"
        const val EVENT_INVENTORY_DETAILS_PAGE_LOAD = "InventoryDetailsPageLoad"
        const val EVENT_INVENTORY_PRODUCT_EDIT = "InventoryProductEdit"
        const val EVENT_ADD_INVENTORY_LOC_SCAN = "AddInventoryLocScan"
        const val EVENT_ADD_INVENTORY_LOC_SEARCH = "AddInventoryLocSearch"
        const val EVENT_INVENTORY_LOC_PRODUCT_COPY = "InventoryLocProductCopy"
        const val EVENT_INVENTORY_LOC_PRODUCT_MOVE = "InventoryLocProductMove"
        const val EVENT_SCAN_RESULT = "ScanResult"

        //Adobe
        const val EVENT_TYPE_TRACK_STATE = "trackState"
        const val EVENT_TYPE_TRACK_ACTION = "trackAction"

        //Flurry
        const val PROPERTY_USER = "User"
        const val PROPERTY_CONNECTIVITY = "Connectivity"
        const val PROPERTY_RIGHT_TO_SUBMIT_ORDER = "RightToSubmitOrder"
        const val PROPERTY_ERROR_MESSAGE = "ErrorMessage"
        const val PROPERTY_DC_ACCOUNT = "DC-Account"
        const val PROPERTY_TAB = "Tab"
        const val PROPERTY_AUDIT_COUNT = "AuditCount"
        const val PROPERTY_ORDER_COST = "OrderCost"
        const val PROPERTY_ORDER_COST_RANGE = "OrderCostRange"
        const val PROPERTY_NUMBER_OF_ORDERS = "NumberOfOrders"
        const val PROPERTY_NUMBER_OF_ITEMS = "NumberOfItems"
        const val PROPERTY_NUMBER_OF_C2_ORDERS = "NumberOfC2Orders"
        const val PROPERTY_ORIGINAL_CIN = "OriginalCIN"
        const val PROPERTY_ALTERNATE_CIN = "AlternateCIN"
        const val PROPERTY_SOURCE_PRODUCT = "SourceProduct"
        const val PROPERTY_FROM = "From"
        const val PROPERTY_LOOKUP_TYPE = "LookupType"
        const val PROPERTY_LOOKUP_KEY = "LookupKey"
        const val PROPERTY_ORDER_TYPE = "OrderType"
        const val PROPERTY_CONTROLLED = "Controlled"
        const val PROPERTY_AUDIT_COUNT_RANGE = "AuditCountRange"
        const val PROPERTY_OPEN_INVENTORY_COUNT = "OpenInventoryCount"
        const val PROPERTY_CLOSED_INVENTORY_COUNT = "ClosedInventoryCount"
        const val PROPERTY_TOTAL_INVENTORY_COUNT = "TotalInventoryCount"
        const val PROPERTY_COST_TYPE = "CostType"
        const val PROPERTY_LOCATION_ID = "LocationId"
        const val PROPERTY_LOCATION_NAME = "LocationName"

        const val PROPERTY_ISSUE_TYPE = "IssueType"
        const val PROPERTY_TOTE_ID = "ToteID"
        const val PROPERTY_INVOICE_ID = "InvoiceID"
        const val PROPERTY_SHIPMENT_ID = "ShipmentID"
        const val PROPERTY_REASON_TYPE = "ReasonType"
        const val PROPERTY_IMPACTED_ITEM_QUANTITY = "ImpactedItemQty"
        const val PROPERTY_ITEM_RANGE = "ItemRange"
        const val PROPERTY_LOCATION_COST = "LocationCost"
        const val PROPERTY_LOCATION_COST_RANGE = "LocationCostRange"
        const val PROPERTY_DATE_TIME_STAMP = "CreatedDatetimeStamp"

        const val PROPERTY_NUMBER_OF_TOTES = "NumberOfTotes"
        const val PROPERTY_TOTE_UPLOAD_RANGE = "ToteUploadRange"
        const val PROPERTY_NUMBER_OF_LOCATIONS = "NumberOfLocations"
        const val PROPERTY_LOCATION_RANGE = "Location Range"
        const val PROPERTY_INVENTORY_VALUE = "InventoryValue"
        const val PROPERTY_INVENTORY_VALUE_RANGE = "InventoryValueRange"
        const val PROPERTY_COUNT_TYPE = "CountType"
        const val PROPERTY_MODIFIED_DATE_TIME_STAMP = "ModifiedDatetimeStamp"
        const val PROPERTY_CREATED_DATE_TIME_STAMP = "CreatedDatetimeStamp"

        const val PROPERTY_SCAN_DATA = "ScanData"
        const val PROPERTY_ORIG_SCAN_VALUE = "orgVal"
        const val PROPERTY_SCAN_SYMBOLOGY = "symb"
        const val PROPERTY_SCAN_OPTIMIZED_VALUE = "modVal"
        const val PROPERTY_SCAN_SUCCESS = "ScanSuccess"
        const val PROPERTY_SCAN_FAILURE = "ScanFailure"

        //Adobe
        const val PROPERTY_V1 = "v1"
        const val PROPERTY_V2 = "v2"
        const val PROPERTY_V4 = "v4"
        const val PROPERTY_V6 = "v6"
        const val PROPERTY_V11 = "v11"
        const val PROPERTY_V12 = "v12"
        const val PROPERTY_V15 = "v15"
        const val PROPERTY_V16 = "v16"
        const val PROPERTY_V17 = "v17"
        const val PROPERTY_V18 = "v18"
        const val PROPERTY_V24 = "v24"
        const val PROPERTY_V27 = "v27"
        const val PROPERTY_V28 = "v28"
        const val PROPERTY_V31 = "v31"
        const val PROPERTY_V32 = "v32"
        const val PROPERTY_V39 = "v39"
        const val PROPERTY_V47 = "v47"
        const val PROPERTY_V48 = "v48"
        const val PROPERTY_V55 = "v55"
        const val PROPERTY_V56 = "v56"
        const val PROPERTY_V57 = "v57"
        const val PROPERTY_V58 = "v58"
        const val PROPERTY_V60 = "v60"
        const val PROPERTY_V64 = "v64"
        const val PROPERTY_V66 = "v66"
        const val PROPERTY_V92 = "v92"
        const val PROPERTY_V93 = "v93"
        const val PROPERTY_V94 = "v94"
        const val PROPERTY_V95 = "v95"

        const val PROPERTY_CH = "ch"

        const val PROPERTY_C1 = "c1"
        const val PROPERTY_C3 = "c3"
        const val PROPERTY_C4 = "c4"
        const val PROPERTY_C7 = "c7"
        const val PROPERTY_C23 = "c23"
        const val PROPERTY_C25 = "c25"
        const val PROPERTY_C34 = "c34"
        const val PROPERTY_C55 = "c55"
        const val PROPERTY_V108 = "v108"

        const val PROPERTY_L1 = "l1"
        const val PROPERTY_L3 = "l3"

        const val PROPERTY_CID = "cid"
        const val PROPERTY_CC = "cc"
        const val PROPERTY_PAGE_NAME = "pageName"
        const val PROPERTY_EVENTS = "events"
        const val PROPERTY_EVENTS_WITH_EQUALS = "events="
        const val PROPERTY_EVENT_WITH_UPPERCASE = "Events="
        const val PROPERTY_LIST1 = "List 1"
        const val PROPERTY_LIST3 = "List 3"
        const val PROPERTY_PRODUCTS = "&&products"
        const val PROPERTY_PURCHASE_ID = "purchaseID"
        const val PROPERTY_PRODUCTS_TEXT = "products"
        const val PROP_7 = "prop7"

        // AOC EVAR26 property
        const val PROPERTY_EVAR_26 = "evar26"

        //Flurry
        const val CONNECTIVITY_WIFI = "WiFi"
        const val CONNECTIVITY_CELLULAR = "Cellular"
        const val CONNECTIVITY_NO_CONNECTION = "No Connection"
        const val PERMITTED = "Permitted"
        const val NOT_PERMITTED = "Not Permitted"
        const val AUDITS = "Audits"
        const val CARTS = "Carts"
        const val ORDERS = "Orders"
        const val DASHBOARD = "Home"
        const val DASHBOARD_CAPITALISED = "Dashboard"
        const val FEEDBACK = "Feedback"
        const val MORE = "More"
        const val RECEIVING = "Receiving"
        const val CART = "cart"
        const val ORDER_DETAILS = "Order Details"
        const val HOME = "Home"
        const val SEARCH = "Search"
        const val SCAN = "Scan"
        const val ORDER_DETAILS_PAGE = "Order Details"
        const val YES = "Yes"
        const val NO = "No"
        const val ORDER_TYPE_C2 = "C2"
        const val ORDER_TYPE_NON_C2 = "NonC2"
        const val SEARCH_RESULT = "Search Results"
        const val SOURCE = "SOURCE"
        const val PRODUCT_DETAILS = "Product Details"
        const val INVENTORY_DETAILS = "Inventory Details"
        const val INVENTORY_DELETE = "Inventory Delete"
        const val INVENTORY_LOCATION_DELETE = "Inventory Location Delete"
        const val INVENTORY_LOCATION_PRODUCT_DELETE = "Inventory Location Product Delete"
        const val INVENTORY_LOCATION_PRODUCT_MOVE = "Inventory Location Product Move"
        const val INVENTORY_LOCATION_PRODUCT_COPY = "Inventory Location Product Copy"
        const val ISSUE_TOTE_LEVEL = "Tote Level"
        const val ISSUE_PRODUCT_LEVEL = "Product Level"
        const val NOT_APPLICABLE = "N/A"
        const val RANGE_SEPARATOR = "_"
        const val CALL_TO_CANCEL = "Call to Cancel"
        const val ORDER_CLICK = "Order Click"
        const val BACK_UP_CART = "Backup Cart"
        const val COPY_ORDERS = "Copy Orders"
        const val CONTINUE_ORDERS = "Continue Orders"
        const val ZERO_RESULTS_SCAN = "zero results scan"
        const val OPPORTUNITY_ANALYSIS = "Opportunity Analysis"
        const val MORE_ALTERNATES = "More Alternates"
        const val PASSCODE_VERIFY = "Verify Passcode"
        const val PASSCODE_RESEND = "Resend Passcode"
        const val CHOOSE_DIFFERENT_AUTHENTICATION = "Choose Different Authentication"
        const val BACK_TO_SIGN_IN = "Back To Sign In"
        const val SIGN_IN_CAMEL_CASE = "Sign In"

        //Adobe
        const val KEY_CAH_OE_MOBILE = "cah:oe:mobile:"
        const val KEY_CAH_OE_DASHBOARD = "cah:oe:mobile:dashboard"
        const val DEFAULT_PAGE_NAME = "DefaultPageName"
        const val EMPTY_STRING = ""
        const val DASHBOARD_PAGE = "dashboard"
        const val MORE_PAGE = "more"
        const val LOGIN_PAGE = "login"
        const val AUTHENTICATION_PAGE = "authentication_page"
        const val SCAN_PAGE = "scan"
        const val MESSAGE_CENTER_PAGE = "messagecentre"
        const val MESSAGE_DETAIL_PAGE = "messagecentre:messagedetail"
        const val ALERT_DETAIL_PAGE = "messagecentre:alertdetail"
        const val ACCOUNT_CHANGE_PAGE = "account change"
        const val ALL_ORDERS_PAGE = "all orders"
        const val OPPORTUNITY_ANALYSIS_PAGE = "opportunityanalysis"
        const val CREATE_AN_ORDER_PAGE = "create an order"
        const val AUDITS_PAGE = "audits"
        const val AUDITS_NON_CIM_PAGE = "audits:non cim"
        const val INVENTORY_LANDING_PAGE = "inventory:getstarted"
        const val INVENTORY_DETAILS_PAGE = "inventory:inventorydetails"
        const val INVENTORY_LOCATION_DETAILS_PAGE = "inventory:locationdetails"
        const val INVENTORY_LOCATION_SELECTION_PAGE = "inventory:locations"
        const val SUGGESTION_PAGE = "aoc suggestions"
        const val SMART_LIST_PAGE = "aoc smart list"
        const val SEARCH_RESULT_PAGE = "search results"
        const val UPLOAD_CONFIRMATION_PAGE = "upload confirmation"
        const val ORDER_HISTORY_PAGE = "Order History"
        const val ORDER_HISTORY_ORDER_VIEW = "Order History:Order View"
        const val RECEIVING_PAGE = "receiving:welcome"
        const val RECEIVING_SHIPMENT_PAGE = "receiving:shipment"
        const val RECEIVING_SHIPMENT_TODAY_PAGE = "receiving:shipment today"
        const val RECEIVING_SHIPMENT_PREVIOUS_PAGE = "receiving:shipment previous"
        const val RECEIVING_INVOICE_PAGE = "receiving:invoice"
        const val RECEIVING_INVOICE_TODAY_PAGE = "receiving:invoice today"
        const val RECEIVING_INVOICE_PREVIOUS_PAGE = "receiving:invoice previous"
        const val ORDER_CONFIRMATION_PAGE = "order confirmation"
        const val UTN_ENTRY_PAGE = "utn entry"
        const val ALTERNATE_LISTING_PAGE = "alternatelist"
        const val SIGN_AND_PLACE_ORDER_FEATURE_PAGE = "sign & place order confirmation"
        const val DELIVERY_CLOSURE_PAGE = "delivery closure"
        const val INTERVENTION_SCREEN_PAGE = "intervention screen"
        const val SIGNATURE_NEEDED = "signature needed"
        const val INVENTORY_CREATE_NEW = "Inventory:create new"
        const val SIGN_AND_PLACE_ORDER = "Sign & Place Order"
        const val SIGN_NOW = "Sign Now"
        const val FORGOT_PASSWORD_PASSCODE = "forgot password passcode"
        const val FORGOT_PASSWORD_AUTHENTICATION = "forgot password authentication"
        const val FORGOT_PASSWORD_EMAIL_SUCCESS = "forgot password email success"
        const val FORGOT_PASSWORD_NEW_PASSWORD_UPDATE = "forgot password new password update"
        const val UPDATE_PASSWORD = "Update Password"
        const val AUDITS_SEARCH_PAGE = "audits search"
        const val AUDITS_SCAN_PAGE = "audits scan"
        const val FORGOT_PASSWORD_UPDATE_SUCCESS = "forgot password successful update"
        const val CHECK_UTN_AVAILABILITY = "Check UTN Availability"
        const val USD = "USD"
        const val PHARMA_MOBILE = "pharma mobile"
        const val NAVIGATED = "navigated"
        const val EVENT_PURCHASE = "purchase"
        const val EVENT_1 = "event1"
        const val EVENT_PROD_VIEW = "prodView"
        const val EVENT_2 = "event2"
        const val EVENT_4_PROD_VIEW = "event4, prodView"
        const val EVENT_5 = "event5"
        const val EVENT_9 = "event9"
        const val EVENT_14_PROD_VIEW = "event14, prodView"
        const val EVENT_14_PROD_VIEW_72 = "event14, prodView, event72"
        const val EVENT_15 = "event15"
        const val EVENT_16 = "event16"
        const val EVENT_22 = "event22"
        const val EVENT_22_PURCHASE_81_15_16 = "event22, purchase, event81, event15, event16"
        const val EVENT_36 = "event36"
        const val EVENT_136 = "event136"
        const val EVENT_138 = "event138"
        const val EVENT_139 = "event139"
        const val EVENT_36_83 = "event36, event83"
        const val EVENT_36_95 = "event36, event95"
        const val EVENT_36_112 = "event36, event112"
        const val EVENT_36_110_107 = "event36, event110, event107"
        const val EVENT_36_111_107 = "event36, event111, event107"
        const val EVENT_36_126_127_128 = "event36, event126, event127, event128"
        const val EVENT_72 = "event72"
        const val EVENT_81 = "event81"
        const val EVENT_82 = "event82"
        const val EVENT_95 = "event95"
        const val EVENT_100_101 = "event100, event101"
        const val EVENT_101 = "event101"
        const val EVENT_102 = "event102"
        const val EVENT_103 = "event103"
        const val EVENT_101_103 = "event101, event103"
        const val EVENT_104 = "event104"
        const val EVENT_113 = "event113"
        const val EVENT_114 = "event114"
        const val EVENT_114_121_122_120 = "event114, event121, event122, event120"
        const val EVENT_115 = "event115"
        const val EVENT_120 = "event120"
        const val EVENT_121 = "event121"
        const val EVENT_122 = "event122"
        const val EVENT_127 = "event127"
        const val EVENT_128 = "event128"
        const val EVENT_130 = "event130"
        const val EVENT_131 = "event131"
        const val EVENT_132 = "event132"
        const val EVENT_133 = "event133"
        const val EVENT_5_88 = "event5, event88"
        const val EVENT_96 = "event96"
        const val EVENT_97 = "event97"
        const val EVENT_98 = "event98"
        const val EVENT_99 = "event99"
        const val EVENT_108 = "event108"
        const val EVENT_109 = "event109"
        const val EVENT_201 = "event201"
        const val EVENT_203 = "event203"
        const val EVENT_E_VAR_109 = "eVar109"
        const val SHIPMENT_STATUS = "shipment status:"
        const val STATUS_NOT_AVAILABLE = "Not available"
        const val EVENT_4_86 = "event4, event86, prodView"
        const val EVENT_14_72 = "event14, event72, prodView"
        const val EVENT_14_72_15_16_19 =
            "event14, prodView, event72, scAdd, scOpen, event15, event16, event19"
        const val EVENT_4_15_16 = "event4, prodView, scAdd, scOpen, event15, event16"
        const val EVENT_4_86_15_16_36 =
            "event4, event86, prodView, scAdd, scOpen, event15, event16, event36"
        const val EVENT_36_127_128 = "event36, scRemove, event127, event128"
        const val EVENT_AOC_ADD_TO_ORDER_EVENTS =
            "scAdd, scOpen, event15, event49, event16, event48"
        const val EVENT_AOC_SUGGESTION = "aoc suggestions:"
        const val EVENT_36_91 = "event36, event91"
        const val EVENT_36_92 = "event36, event92"
        const val EVENT_45 = "event45"
        const val EVENT_46 = "event46"
        const val EVENT_INVENTORY_LOCATION_DETAILS =
            "event4, prodView, event108, event109, event105"
        const val EVENT_123 = "event123"
        const val EVENT_124 = "event124"
        const val EVENT_137 = "event137"
        const val EVENT_REMOVE_ORDER = "scRemove, event16"
        const val EVENT_135 = "event135"
        const val EVENT_129 = "event129"
        const val EVENT_134 = "event134"
        const val FIRST_VISIT = "first visit"
        const val LESS_THAN_ONE_DAY = "less than 1 day"
        const val DAY_SINCE_LAST_VISIT = " day since last visit"
        const val D_EQUAL_TO = "D="
        const val G = "g"
        const val ALERT = "Alert: "
        const val MESSAGE = "Message: "
        const val DIVIDER = "|"
        const val FEATURED_LINKS = "featuredlinks : "
        const val SHIPMENT_MODULE = "shipment module:"
        const val ACTIVE_BACKORDER_SEARCH = "Active Backorder : Search"
        const val BACKORDER_HISTORY_SEARCH = "Backorder History : Search"
        const val SPACE_BETA_OPT_IN = " Beta Opt-in"
        const val SPACE_BETA_OPT_OUT = " Beta Opt-out"
        const val SIGN_IN = "sign in"
        const val SIGN_IN_TITLE_CASE = "Sign In"
        const val FORGOT_PASSWORD = "Forgot Password"
        const val TYPE_MAIL = "mail"
        const val TYPE_SMS = "sms"
        const val TYPE_CALL = "call"
        const val TEXT_MESSAGE = "authentication Type Text Message"
        const val CALL_MESSAGE = "authentication Type Call Message"
        const val EMAIL_MESSAGE = "authentication Type Email Message"
        const val SOAR_GO_TO_RECEIVING = "go to receiving"
        const val SOAR_TILE_REFRESH = "refresh"
        const val SOAR_TILE_ARROW_NEXT_NAVIGATION = "next"
        const val SOAR_TILE_ARROW_PREVIOUS_NAVIGATION = "previous"
        const val SOAR_SHIPMENT_MODULE = "dashboard:shipment module"

        const val FORGOT_RESET_GUIDE = "Password Reset Guide"
        const val L1_VALUE = "Dashboard|Whats_New,Dashboard|Newsletter_signup,Dashboard|survey"
        const val L1_VALUE_AOC = "AOC Banner Tile|Dashboard|1"
        const val NEWSLETTER_SIGN_UP = "Newsletter_signup"
        const val SURVEY = "survey"
        const val OE_INSIDER_SIGN_UP = "OE Insider Sign Up"
        const val ERROR_CODE = "error code"
        const val HISTORY = "history"
        const val NEW_ORDER = "new order"
        const val LIST = "lists"
        const val OPINION_LAB_SURVEY = "OpinionLab Survey"
        const val CHANGE_ACCOUNT = "change account"
        const val ACTIVATE_SCAN = "activate scan"
        const val INTERNAL_SEARCH = "internal search"
        const val INTERNAL_SCAN = "internal scan"
        const val EVAR_INTERNAL_SCAN_RESULT = "internal scan:results"
        const val EVAR_INTERNAL_SEARCH_RESULT = "internal search:results"
        const val EVAR_UPLOAD_ORDER = "orders:upload order"
        const val EVAR_UPLOAD_ALL_ORDER = "orders:upload all orders"
        const val EVAR_PLACE_ORDER = "orders:place order"
        const val EVAR_PLACE_ALL_ORDER = "orders:place all orders"
        const val EVAR_PLACE_C2_ORDER = "orders:place C2 order"
        const val EVAR_DASHBOARD = "dashboard:aem component"
        const val CATALOG_SEARCH_BOX_MANUAL = "catalog search box:manual"
        const val CATALOG_SEARCH_PRE_DEFINED = "catalog search box:pre-defined"
        const val EVAR_ALTERNATE_SUGGESTION_SCAN_RESULTS = "alternate suggestion:scan results"
        const val EVAR_ALTERNATE_SUGGESTION_SEARCH_RESULTS = "alternate suggestion:search results"
        const val REFERERRING_ALTERNATE_PRODUCT_SCAN = "referring alternate product:scan"
        const val REFERRRING_ALTERNATE_PRODUCT_SEARCH_RESULT =
            "referring alternate product:search results"
        const val EVAR_OA_SUGGESTION = "OA suggestion"
        const val EVAR_IGNORE_ACTION_AGAINST = "IgnoreActionAgainst"
        const val EVAR_22 = "evar22="
        const val EVAR_23 = "evar23="
        const val EVAR_33 = "evar33="
        const val EVAR_9 = "evar9="
        const val EVAR_19 = "evar19="
        const val EVAR_26 = "evar26="
        const val EVAR_27 = "evar27="
        const val EVAR_28 = "evar28"
        const val EVAR_30 = "evar30="
        const val EVAR_45 = "evar45="
        const val EVAR_49 = "evar49="
        const val EVAR_114 = "evar114="
        const val EVAR_115 = "evar115="
        const val EVAR_116 = "evar116="
        const val EVAR_117 = "evar117="
        const val SEARCH_RESULTS_ALT = "search results alt"
        const val CATALOG_SEARCH_BOX = "catalog search box:"
        const val MANUAL = "manual"
        const val DEFAULT_PAGE_POSITION = "1:1"
        const val CREATE_INVENTORY = "Create Inventory"
        const val OPEN_CREATE_NEW_LOCATION = "Open Create New Location"
        const val CREATE_NEW_LOCATION = "Create New Location"
        const val CREATE_NEW_ORDER = "Create new order"
        const val D_EQUAL_TO_V32 = "D=v32"
        const val PLACE_ORDER = "place order"
        const val SUBMIT_ORDER = "Submit Order"
        const val SUBMIT_ALL_ORDERS = "Submit All Orders"
        const val LOCATION_UPLOAD = "Location Upload"
        const val LOCATION_SHARE = "Location Share"
        const val UPLOAD_ORDER = "upload order"
        const val UPLOAD_ORDER_CAPITALISED = "Upload Order"
        const val UPLOAD_C2_ORDER = "upload c2 order"
        const val UPLOAD_ALL_ORDER = "upload all orders"
        const val UPLOAD_ALL_ORDER_CAPITALISED = "Upload All Order"
        const val PLACE_ALL_ORDER = "place all orders"
        const val PLACE_C2_ORDER = "place c2 order"
        const val SUBMIT_GROUPS = "Submit Groups"
        const val RECEIVING_CONTINUE = "Receiving Continue"
        const val TOTE_ITEM_CLICK = "Tote Item Click"
        const val INCOMPLETE_RECEIVING_ITEMS = "Incomplete receiving Items"
        const val RECEIVING_ISSUE_CLICK = "receiving issue click"
        const val UPLOAD_COMPLETED_TOTES = "Upload Completed Totes"
        const val EVENT_OC_PRODUCT_COUNT = "OCProductCount"
        const val PROPERTY_OC_PRODUCT_COUNT_RANGE = "OCProductCountRange"
        const val SIGN_OUT = "Sign Out"
        const val BCS_SAVED_ORDERS = "savedorders"
        const val BCS_SAVED_ORDER_DETAILS = "savedorderdetail"
        const val ONLINE = "onlineMode"
        const val OFFLINE = "offlineMode"
        const val EMERGENCY_ORDERING = "emergencyMode"
        const val EVENT_18 = "event18"
        const val EVENT_19 = "event19"
        const val SC_ADD = "scAdd"
        const val SC_OPEN = "scOpen"
        const val C2_ORDERS = "C2 Orders"
        const val NON_C2_ORDERS = "Non-C2 Orders"
        const val TEMP_CRASH_CATCH = "crash-catch"
        const val TEMP_LOG_PAGE_VISIT = "CurrentPageAndPreviousPage"
        const val EVENT_47 = "event47"
        const val EVENT_49 = "event49"
        const val AOC_BANNER_TILE = "AOC Banner Tile"
        const val AOC_SHOW_ALL = "Show All"
        const val KEY_PRODUCTS = "products"
        const val FEATURE_CART_SYNC = "Sync Cart"
        const val DELIVERY_CLOSURE = "Delivery Closure"
        const val RECEIVING_UPLOAD_COMPLETED_TOTES = "Receiving Upload Completed Totes"
        const val CLICKED = "clicked"
        const val LOWER_CASE_SEARCH = "search"
        const val LOWER_CASE_SCAN = "scan"
        const val ORDERING_SCAN = "orderingScan"
        const val PRICE_CHECK_SCAN = "priceCheckScan"
        const val RECENT_ACTIVITY_UPPERCASE = "Recent Activity "
        const val RECENT_ACTIVITY = "recent activity"
        const val DETAILS = "Details"
        const val FILTER = "Filter"
        const val BETA_FEATURE_CART_SYNC = "Cart Sync"
        const val CART_SYNC_THRESHOLD_ERROR_CODE = "50100"
        const val ORDER_DELETED = "order deleted"
        const val ORDER_DELETED_CAPITALISED = "Order Deleted"
        const val NON_C2_ORDER_TAB = "non c2 orders tab"
        const val C2_ORDER_TAB = "c2 orders tab"
        const val PRICE_CHECK_TOGGLE_SCAN = "price check toggle scan"
        const val ORDERING_TOGGLE_SCAN = "ordering toggle scan"
        const val ADD_TO_ORDER = "Add To Order"
        const val START_DIAGNOSIS = "Start Diagnosis"
        const val CREATE_DIAGNOSIS_REPORT = "Create Diagnostic Report"
        const val REPORT_A_PROBLEM = "Report a Problem"
        const val REMOVE_ITEM = "remove item"
        const val RESET_VIA_TEXT = "Reset Via Text"
        const val RESET_VIA_CALL = "Reset Via Call"
        const val RESET_VIA_MAIL = "Reset Via Mail"
        const val VERIFY_PASSCODE = "Verify Passcode"
        const val RESEND_PASSCODE = "Resend Passcode"
        const val RETURN_TO_HOME = "Return to Home"
        const val RESTART_DIAGNOSIS = "Restart Diagnosis"
        const val INVENTORY = "Inventory"
        const val AUDITS_GO_TO_AUDIT_GROUP = "Audits:Go to audit group"
        const val AUDITS_SUBMIT_CONFIRMED_ITEMS = "audits:submit confirmed items"

        // BackOrderAnalytics
        const val BO_ACTIVE_BACK_ORDER_PAGE_NAME = "active backorder"
        const val BO_BACK_ORDER_HISTORY_PAGE_NAME = "backorder history"
        const val BO_BACK_ORDER_LIST_ITEM_NAME = "Backorder List"

        // Smart Order Analytics
        const val SMART_ORDER_PAGE_NAME = "smart order settings"
        const val SMART_ORDER_SAVE_SETTINGS = "Smart Order Save Settings"
        const val SAVE_SETTINGS = "save settings"
        const val MANAGE_FEATURE = "manage feature"
        const val MANAGE_FEATURE_SMART_ORDER = "Manage Features Smart Order"
        const val SMART_ORDER = "smart orders"
        const val SMART_ORDER_SINGULAR = "smart order"
        const val SMART_ORDER_IGNORE = "smart order:ignore"
        const val SMART_ORDER_FEEDBACK_PAGE_NAME = "Smart Order Feedback"
        const val SMART_ORDER_SUBMIT_FEEDBACK = "submit feedback"
        const val THREE_SEMI_COLON = ";;;"
        const val SPACE_COLON_SPACE = " : "

        // CIM Enhancements
        const val CIM_AUTO_CREATE_LOCATION = "inventory:auto-create location"
        const val CIM_INVENTORY_AUTO_CREATE = "inventory:auto-create"
        const val CIM_ADD_LOCATION = "inventory:add location"
        const val CIM_AUTO_CREATE_LOCATION_PAGE_NAME = "auto-create location"
    }
}